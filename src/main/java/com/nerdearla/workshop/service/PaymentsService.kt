package com.nerdearla.workshop.service

import com.nerdearla.workshop.dto.payment.PaymentRequest.buyerId
import com.nerdearla.workshop.dto.payment.PaymentRequest.paymentMethod
import com.nerdearla.workshop.dto.payment.PaymentRequest.sellerId
import com.nerdearla.workshop.model.Buyer
import com.nerdearla.workshop.model.Seller
import com.nerdearla.workshop.dto.payment.PaymentRequest
import com.nerdearla.workshop.model.PaymentOperation
import com.nerdearla.workshop.service.PaymentIdProvider
import com.nerdearla.workshop.service.UserService
import com.nerdearla.workshop.service.PaymentMethodService
import com.nerdearla.workshop.service.FraudService
import com.nerdearla.workshop.service.GatewayService
import com.nerdearla.workshop.dto.payment.PaymentResponse
import com.nerdearla.workshop.dto.payment.PaymentMethod
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import com.nerdearla.workshop.service.PaymentsService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid
import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.jvm.JvmStatic
import org.springframework.boot.SpringApplication
import org.springframework.stereotype.Service

@Service
class PaymentsService(
    private val paymentIdProvider: PaymentIdProvider,
    private val userService: UserService,
    private val paymentMethodService: PaymentMethodService,
    private val fraudService: FraudService,
    private val gatewayService: GatewayService
) {
    fun processPayment(paymentRequest: PaymentRequest?): PaymentResponse {
        val id = paymentIdProvider.next
        userService.findValidUser(paymentRequest!!.buyerId)
        paymentMethodService.authorize(paymentRequest.paymentMethod)
        userService.findValidUser(paymentRequest.sellerId)
        val operation = PaymentOperation()
        fraudService.authorize(operation)
        gatewayService.authorize(operation)
        return PaymentResponse()
    }
}