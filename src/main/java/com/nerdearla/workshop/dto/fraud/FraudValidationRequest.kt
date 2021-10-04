package com.nerdearla.workshop.dto.fraud

data class FraudValidationRequest(
    val identification: String,
    val amount: Double
)