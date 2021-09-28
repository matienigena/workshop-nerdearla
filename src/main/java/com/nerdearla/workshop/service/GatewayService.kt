package com.nerdearla.workshop.service

import com.nerdearla.workshop.dto.authorization.PaymentAuthorizationRequest
import com.nerdearla.workshop.dto.authorization.PaymentAuthorizationResponse
import com.nerdearla.workshop.model.FullOperation
import com.nerdearla.workshop.model.NotFraudulentOperation
import com.nerdearla.workshop.model.PaymentAuthorization
import com.nerdearla.workshop.validator.GatewayResponseValidator
import org.springframework.stereotype.Service

@Service
class GatewayService(
    private val validator: GatewayResponseValidator
) {

    fun authorize(operation: NotFraudulentOperation) =
        operation
            .toPaymentAuthorizationRequest()
            .callGateway()
            .also { validator.validate(it) }
            .toPaymentAuthorization()

    private fun NotFraudulentOperation.toPaymentAuthorizationRequest() =
        PaymentAuthorizationRequest(
            paymentMethodToken = buyerPaymentMethod.token,
            paymentMethodSecurityCode = buyerPaymentMethod.securityCode,
            holderIdentification = buyer.identification,
            establishmentId = terminalData.establishmentId,
            terminalNumber = terminalData.terminalNumber,
            ticketNumber = terminalData.ticketNumber,
            traceNumber = terminalData.traceNumber,
            transactionDatetime = terminalData.transactionDatetime
        )

    // Ver de meter alguna estrategia o factory dependiendo del tipo de pago?
    // De eso se encargaría el gateway real pero bueno
    // TODO: Llamada a service externo
    private fun PaymentAuthorizationRequest.callGateway() =
        PaymentAuthorizationResponse(
            id = "1",
            traceNumber = "2",
            status = "OK"
        )

    private fun PaymentAuthorizationResponse.toPaymentAuthorization() =
        PaymentAuthorization(id, traceNumber, status)
}
