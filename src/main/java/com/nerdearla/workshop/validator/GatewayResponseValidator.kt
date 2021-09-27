package com.nerdearla.workshop.validator

import com.nerdearla.workshop.dto.authorization.PaymentAuthorizationResponse
import org.springframework.stereotype.Component

@Component
interface GatewayResponseValidator {

    fun validate(response: PaymentAuthorizationResponse) {}
}