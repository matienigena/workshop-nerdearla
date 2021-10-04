package com.nerdearla.workshop.dto.buyer.paymentMethod

data class BuyerPaymentMethod(
    val id: String,
    val enabled: Boolean,
    val type: String,
    val securityCode: String,
    val token: String
)
