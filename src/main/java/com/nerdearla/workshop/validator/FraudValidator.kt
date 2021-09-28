package com.nerdearla.workshop.validator

import com.nerdearla.workshop.dto.fraud.FraudValidationResponse
import org.springframework.stereotype.Component

@Component
class FraudValidator {

    fun validate(fraudValidationResponse: FraudValidationResponse) {
        when {
            operationIsNotAllowed(fraudValidationResponse) -> throwOperationNotAllowed()
        }
    }

    private fun throwOperationNotAllowed() {
        throw RuntimeException("Operation is not allowed").also {
            // TODO: logging
        }
    }

    private fun operationIsNotAllowed(fraudValidationResponse: FraudValidationResponse) =
        fraudValidationResponse.result != "ACCEPTED"
}