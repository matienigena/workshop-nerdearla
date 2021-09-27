package com.nerdearla.workshop.service

import com.nerdearla.workshop.model.Address
import com.nerdearla.workshop.model.Seller
import com.nerdearla.workshop.validator.SellerValidator
import org.springframework.stereotype.Service

@Service
class SellerService(
    private val validator: SellerValidator
) {
    // TODO: Llamada a service externo
    fun findSeller(sellerId: String?) = Seller(
        id = "1",
        enabled = true,
        email = "seller@seller.com",
        identification = "123456",
        name = "Seller SA",
        address = Address(
            id = "1",
            city = "a",
            country = "b",
            line1 = "fake street 123",
            line2 = "A",
            postalCode = "AAA123456C",
            state = "ASD"
        )
    ).also {
        validator.validate(it)
    }
}
