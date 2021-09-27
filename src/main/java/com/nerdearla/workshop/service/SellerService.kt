package com.nerdearla.workshop.service

import com.nerdearla.workshop.model.Seller
import com.nerdearla.workshop.validator.SellerValidator
import org.springframework.stereotype.Service

@Service
class SellerService(
    private val validator: SellerValidator
) {
    // TODO: Llamada a service externo
    fun findSeller(sellerId: String?) =
        Seller( id = "1", enabled = true). also {
            validator.validate(it)
        }
}
