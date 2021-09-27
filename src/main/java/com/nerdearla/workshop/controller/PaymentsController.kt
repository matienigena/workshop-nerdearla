package com.nerdearla.workshop.controller

import com.nerdearla.workshop.dto.payment.PaymentRequest
import com.nerdearla.workshop.dto.payment.PaymentResponse
import com.nerdearla.workshop.mapper.PaymentResponseMapper
import com.nerdearla.workshop.model.InitialOperation
import com.nerdearla.workshop.model.Payment
import com.nerdearla.workshop.service.PaymentService
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
    fun processPayment(@RequestBody paymentRequest: @Valid PaymentRequest): PaymentResponse =
        paymentRequest
            .buildOperation()
            .process()
            .toResponse()

    private fun PaymentRequest.buildOperation() =
        InitialOperation(
            amount = amount,
            buyerId = buyerId,
            paymentMethodData = paymentMethodData,
            qrId = qrId,
            sellerId = sellerId,
            terminalData = terminalData
        )

    private fun InitialOperation.process() =
        paymentsService.processPayment(this)

    private fun Payment.toResponse() =
        paymentResponseMapper.map(this)

}
