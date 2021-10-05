package com.nerdearla.workshop.user.buyer.validator

import com.nerdearla.workshop.user.buyer.Buyer
import com.nerdearla.workshop.user.buyer.client.DisabledBuyerError
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Component

@Component
class BuyerValidator {

    fun validate(buyer: Buyer) {
        buyer.validateIsEnabled()
    }

    private fun Buyer.validateIsEnabled() {
        if (enabled.not()) {
            log.error("buyer {} is disabled", id)
            throw DisabledBuyerError()
        }
        log.info("buyer {} is enabled", id)
    }


    companion object : CompanionLogger()
}
