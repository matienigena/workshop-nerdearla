package com.nerdearla.workshop.dto.payment

data class PaymentMethodData(
    val token: String,
    val securityCode: String
)