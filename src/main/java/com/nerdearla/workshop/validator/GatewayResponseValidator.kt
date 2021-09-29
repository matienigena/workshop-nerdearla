package com.nerdearla.workshop.validator

import com.nerdearla.workshop.dto.authorization.PaymentAuthorizationResponse
import org.springframework.stereotype.Component

@Component
class GatewayResponseValidator {

    fun validate(response: PaymentAuthorizationResponse) {
        when {
            response.status != "ACCEPTED" -> throwFailedPayment()
        }
    }

    private fun throwFailedPayment() {
        throw RuntimeException("Payment failed").also {
            // TODO: log error
        }
    }
}