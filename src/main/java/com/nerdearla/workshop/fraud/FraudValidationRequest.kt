package com.nerdearla.workshop.fraud

data class FraudValidationRequest(
    val identification: String,
    val amount: Double
)
