package com.nerdearla.workshop.model

data class Seller(
    val id: String,
    val identification: String,
    val enabled: Boolean,
    val name: String,
    val email: String,
    val address: Address
)

