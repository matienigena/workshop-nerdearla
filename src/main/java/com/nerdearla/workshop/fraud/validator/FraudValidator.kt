package com.nerdearla.workshop.fraud.validator

import com.nerdearla.workshop.fraud.FraudValidationResponse
import com.nerdearla.workshop.fraud.error.OperationNotAllowedError
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Component

@Component
class FraudValidator {

    fun validate(fraudValidation: FraudValidationResponse) {
        fraudValidation.validateTxIsAllowed()
    }

    private fun FraudValidationResponse.validateTxIsAllowed() {
        if (result != "ALLOWED") {
            log.error("operation not allowed")
            throw OperationNotAllowedError()
        }

        log.info("operation allowed")
    }

    companion object : CompanionLogger()
}
