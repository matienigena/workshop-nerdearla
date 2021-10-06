package com.nerdearla.workshop.payment.model

import javax.validation.constraints.Pattern

data class PaymentMethodData(
    val token: String,

    @Pattern(regexp = "^[0-9]*\$")
    val securityCode: String
)
