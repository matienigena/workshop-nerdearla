package com.nerdearla.workshop.validator

import com.nerdearla.workshop.dto.seller.Seller
import org.springframework.stereotype.Component

@Component
class SellerValidator {

    fun validate(seller: Seller) {
        when {
            !seller.enabled -> throwDisabledSeller()
        }
    }

    private fun throwDisabledSeller() {
        throw RuntimeException("Seller is not enabled").also {
            // TODO: logging
        }
    }


}