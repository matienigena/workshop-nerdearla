package com.nerdearla.workshop.service

import com.nerdearla.workshop.dto.payment.TerminalData
import com.nerdearla.workshop.model.Payment.PaymentBuilder
import com.nerdearla.workshop.model.PaymentOperation
import com.nerdearla.workshop.model.PaymentAuthorization
import com.nerdearla.workshop.model.Payment
import com.nerdearla.workshop.dto.payment.PaymentRequest
import com.nerdearla.workshop.model.QR
import com.nerdearla.workshop.model.Buyer
import com.nerdearla.workshop.model.Seller
import com.nerdearla.workshop.dto.payment.PaymentResponse
import com.nerdearla.workshop.service.PaymentIdProvider
import com.nerdearla.workshop.service.UserService
import com.nerdearla.workshop.service.PaymentMethodService
import com.nerdearla.workshop.service.FraudService
import com.nerdearla.workshop.service.GatewayService
import com.nerdearla.workshop.service.BuyerService
import com.nerdearla.workshop.service.SellerService
import com.nerdearla.workshop.repository.PaymentRepository
import com.nerdearla.workshop.service.QRService
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.http.HttpStatus
import com.nerdearla.workshop.dto.error.APIError
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import com.nerdearla.workshop.service.PaymentService
import com.nerdearla.workshop.mapper.PaymentResponseMapper
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid
import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.jvm.JvmStatic
import org.springframework.boot.SpringApplication
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val paymentIdProvider: PaymentIdProvider,
    private val userService: UserService,
    private val paymentMethodService: PaymentMethodService,
    private val fraudService: FraudService,
    private val gatewayService: GatewayService,
    private val buyerService: BuyerService,
    private val sellerService: SellerService,
    private val paymentRepository: PaymentRepository,
    private val qrService: QRService
) {
    fun processPayment(operation: PaymentOperation): Payment? {
        val id = paymentIdProvider.next
        operation.paymentId = id

        // validar qr_id?
        val qr = qrService.findValidQR(operation.paymentRequest.qrId)
        operation.qr = qr

        // validar amount e installments?
        val buyer = userService.findValidUser(operation.paymentRequest.buyerId)
        operation.buyer = buyerService.findBuyer(buyer.id)

        // Obtener paymentMethod y agregarlo a operation?
        val paymentMethod = paymentMethodService.authorize(operation.paymentRequest.paymentMethod)
        operation.paymentMethod = paymentMethod
        val seller = userService.findValidUser(operation.paymentRequest.sellerId)
        operation.seller = sellerService.findSeller(seller.id)

        // FraudResult que se persista
        fraudService.authorize(operation)
        val authorization = gatewayService.authorize(operation)
        val payment = PaymentBuilder(operation, authorization).build()
        paymentRepository.save(payment)
        return payment
    }
}
