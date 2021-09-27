package com.nerdearla.workshop.model

data class BuyerPaymentMethod(
    val id: String,
    val enabled: Boolean,
    val securityCode: String,
    val token: String
)
