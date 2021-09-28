package com.nerdearla.workshop.validator

import com.nerdearla.workshop.dto.buyer.Buyer
import org.springframework.stereotype.Component
import kotlin.RuntimeException

@Component
class BuyerValidator {

    fun validate(buyer: Buyer, identification: String) {
        when {
            !buyer.enabled -> throwBuyerNotEnabled()
            buyer.identification != identification -> throwInvalidBuyer()
        }
    }

    private fun throwBuyerNotEnabled() {
        throw RuntimeException("Buyer is not enabled").also {
            // TODO: log error
        }
    }

    private fun throwInvalidBuyer() {
        throw RuntimeException("Invalid buyer").also {
            // TODO: log error
        }
    }
}