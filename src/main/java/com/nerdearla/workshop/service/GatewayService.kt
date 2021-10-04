package com.nerdearla.workshop.service

import com.nerdearla.workshop.dto.authorization.PaymentAuthorizationRequest
import com.nerdearla.workshop.dto.authorization.PaymentAuthorizationResponse
import com.nerdearla.workshop.dto.fraud.FraudValidationResponse
import com.nerdearla.workshop.model.FullOperation
import com.nerdearla.workshop.model.NotFraudulentOperation
import com.nerdearla.workshop.model.PaymentAuthorization
import com.nerdearla.workshop.validator.GatewayResponseValidator
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class GatewayService(
    private val validator: GatewayResponseValidator,
    private val webClient: WebClient
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
    private fun PaymentAuthorizationRequest.callGateway() =
        webClient
            .post()
            .uri("/authorizations")
            .body(Mono.just(this), this.javaClass)
            .retrieve()
            .bodyToMono(PaymentAuthorizationResponse::class.java)
            .block()!!

    private fun PaymentAuthorizationResponse.toPaymentAuthorization() =
        PaymentAuthorization(id, traceNumber, status)
}
