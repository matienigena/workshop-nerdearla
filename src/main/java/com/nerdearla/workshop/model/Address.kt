package com.nerdearla.workshop.model

data class Address(
    val id: String,
    val city: String,
    val country: String,
    val line1: String,
    val line2: String,
    val postalCode: String,
    val state: String
)
