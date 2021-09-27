package com.nerdearla.workshop.service

import com.nerdearla.workshop.model.Address
import com.nerdearla.workshop.model.Buyer
import com.nerdearla.workshop.validator.BuyerValidator
import org.springframework.stereotype.Service

@Service
class BuyerService(
    private val validator: BuyerValidator
) {
    // TODO: Llamada a service externo
    fun findBuyer(buyerId: String?) = Buyer(
        id = "1",
        enabled = true,
        identification = "123",
        name = "a",
        lastName = "buyer",
        email = "an@email.com",
        dateOfBirth = "01/01/2020",
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
