package com.nerdearla.workshop.model

data class Buyer(
    val id: String,
    val identification: String,
    val enabled: Boolean,
    val name: String,
    val lastName: String,
    val email: String,
    val dateOfBirth: String,
    val address: Address
)


