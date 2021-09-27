package com.nerdearla.workshop.service

import com.nerdearla.workshop.model.Buyer
import com.nerdearla.workshop.validator.BuyerValidator
import org.springframework.stereotype.Service

@Service
class BuyerService(
    private val validator: BuyerValidator
) {
    // TODO: Llamada a service externo
    fun findBuyer(buyerId: String?) =
        Buyer(id = "1", enabled = true).also {
            validator.validate(it)
        }
}
