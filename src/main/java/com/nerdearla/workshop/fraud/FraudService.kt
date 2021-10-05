package com.nerdearla.workshop.fraud

import com.nerdearla.workshop.fraud.client.FraudClient
import com.nerdearla.workshop.fraud.validator.FraudValidator
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Service

@Service
class FraudService(
    private val validator: FraudValidator,
    private val client: FraudClient
) {
    fun validateFor(identification: String, amount: Double) =
        mapToRequest(identification, amount)
            .doValidation()
            .also { it.validate() }

    private fun mapToRequest(identification: String, amount: Double) =
        FraudValidationRequest(
            identification = identification,
            amount = amount
        )

    private fun FraudValidationRequest.doValidation() =
        client.validate(this)
            .log { info("fraud validated for {} with amount {}", identification, amount) }

    private fun FraudValidationResponse.validate() =
        validator.validate(this)
            .log { info("fraud response validated") }

    companion object : CompanionLogger()
}


