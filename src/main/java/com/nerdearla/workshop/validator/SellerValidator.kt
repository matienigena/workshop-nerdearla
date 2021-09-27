package com.nerdearla.workshop.validator

import com.nerdearla.workshop.model.Seller
import org.springframework.stereotype.Component

@Component
interface SellerValidator {

    fun validate(seller: Seller) {}
}