package com.nerdearla.workshop.service

import com.nerdearla.workshop.dto.fraud.FraudValidationRequest
import com.nerdearla.workshop.dto.fraud.FraudValidationResponse
import com.nerdearla.workshop.model.FullOperation
import com.nerdearla.workshop.validator.FraudValidator
import org.springframework.stereotype.Service

@Service
class FraudService(
    private val validator: FraudValidator
) {
    fun validate(fraudValidationRequest: FraudValidationRequest) =
        fraudValidationRequest
            .toFraudValidationResponse()
            .also {
                validator.validate(it)
            }

    // TODO: llamada http
    private fun FraudValidationRequest.toFraudValidationResponse() =
        FraudValidationResponse(
            fraudValidationId = "132131231",
            result = "ALLOWED"
        )

    private fun FullOperation.toFraudValidationRequest() =
        FraudValidationRequest(
            identification = buyer.identification,
            amount = amount
        )
}


