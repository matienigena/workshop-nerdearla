package com.nerdearla.workshop.payment.controller

import com.nerdearla.workshop.operation.InitialOperation
import com.nerdearla.workshop.payment.PaymentService
import com.nerdearla.workshop.payment.mapper.PaymentResponseMapper
import com.nerdearla.workshop.payment.model.Payment
import com.nerdearla.workshop.payment.model.PaymentRequest
import com.nerdearla.workshop.payment.model.PaymentResponse
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("payments")
class PaymentsController(
    private val paymentsService: PaymentService,
    private val paymentResponseMapper: PaymentResponseMapper
) {

    //Hacer incapie en que no estamos rompiendo el encapsulamiento y el objetivo que tenemos con estas extensiones.
    //Distinguir este tipo de extension de las publicas.
    @PostMapping
    fun processPayment(@RequestBody @Valid paymentRequest: PaymentRequest): PaymentResponse =
        paymentRequest
            .toOperation()
            .process()
            .toResponse()

    private fun PaymentRequest.toOperation() =
        InitialOperation(
            amount = amount,
            buyerId = buyerId,
            paymentMethodData = paymentMethodData,
            qrId = qrId,
            sellerId = sellerId,
            terminalData = terminalData,
            identification = buyerIdentification,
        )

    private fun InitialOperation.process() =
        paymentsService.processPayment(this)
            .log { info("payment processed: {}", it) }

    private fun Payment.toResponse() =
        paymentResponseMapper.map(this)
            .log { info("payment response {}", it) }

    companion object : CompanionLogger()
}
