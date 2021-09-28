package com.nerdearla.workshop.dto.buyer

import com.nerdearla.workshop.model.Address

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


