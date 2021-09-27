package com.nerdearla.workshop.dto.authorization

data class PaymentAuthorizationRequest(
    val paymentMethodToken: String,
    val paymentMethodSecurityCode: String,
    val holderIdentification: String
)