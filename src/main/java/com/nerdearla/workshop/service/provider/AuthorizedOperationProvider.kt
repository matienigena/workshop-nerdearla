package com.nerdearla.workshop.service.provider

import com.nerdearla.workshop.model.*
import com.nerdearla.workshop.service.GatewayService
import org.springframework.stereotype.Component

@Component
class AuthorizedOperationProvider(
    private val gatewayService: GatewayService
) {

    fun provide(notFraudulentOperation: NotFraudulentOperation): AuthorizedOperation =
        with(notFraudulentOperation) {
            AuthorizedOperation(
                authorization = gatewayService.authorize(notFraudulentOperation),
                paymentId = paymentId,
                qr = qr,
                buyerPaymentMethod = buyerPaymentMethod,
                amount = amount,
                installments = installments,
                seller = seller,
                buyer = buyer,
                fraudResponse = fraudResponse,
                terminalData = terminalData
            )
        }
}