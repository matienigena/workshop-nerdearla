package com.nerdearla.workshop.dto.seller

import com.nerdearla.workshop.model.Address

data class Seller(
    val id: String,
    val identification: String,
    val enabled: Boolean,
    val name: String,
    val email: String,
    val address: Address
)

