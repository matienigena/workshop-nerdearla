package com.nerdearla.workshop.payment.model

data class PaymentMethodData(
    val token: String,
    val securityCode: String
)
