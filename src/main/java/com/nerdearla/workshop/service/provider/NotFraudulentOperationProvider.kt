package com.nerdearla.workshop.service.provider

import com.nerdearla.workshop.dto.fraud.FraudValidationRequest
import com.nerdearla.workshop.model.FullOperation
import com.nerdearla.workshop.model.NotFraudulentOperation
import com.nerdearla.workshop.service.FraudService
import org.springframework.stereotype.Component

@Component
class NotFraudulentOperationProvider(
    private val fraudService: FraudService
) {
    // Esto quedó medio feo creo
    fun provide(fullOperation: FullOperation) =
        with(fullOperation) {
            NotFraudulentOperation(
                paymentId = paymentId,
                qr = qr,
                buyerPaymentMethod = buyerPaymentMethod,
                seller = seller,
                buyer = buyer,
                terminalData = terminalData,
                amount = amount,
                installments = installments,
                fraudResponse = toFraudValidationRequest().validateFraud()
            )
        }

    private fun FullOperation.toFraudValidationRequest() =
        FraudValidationRequest(
            identification = buyer.identification,
            amount = amount
        )

    private fun FraudValidationRequest.validateFraud() =
        fraudService.validate(this)

}






