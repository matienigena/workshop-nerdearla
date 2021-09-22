package com.nerdearla.workshop.controller.advice

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
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.http.HttpStatus
import com.nerdearla.workshop.dto.error.APIError
import com.nerdearla.workshop.service.PaymentService
import com.nerdearla.workshop.mapper.PaymentResponseMapper
import javax.validation.Valid
import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.jvm.JvmStatic
import org.springframework.boot.SpringApplication
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestControllerAdvice
class GlobalControllerAdvice {
    @ExceptionHandler(HttpMessageNotReadableException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(e: Exception): APIError {
        return APIError(e.message)
    }
}
