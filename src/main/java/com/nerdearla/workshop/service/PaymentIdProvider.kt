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
class PaymentIdProvider {
    val next: String?
        get() = null
}
