package com.nerdearla.workshop.validator

import com.nerdearla.workshop.model.Buyer
import org.springframework.stereotype.Component

@Component
interface BuyerValidator {

    fun validate(buyer: Buyer) {}
}