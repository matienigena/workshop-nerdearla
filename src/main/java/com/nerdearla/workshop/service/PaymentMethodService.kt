package com.nerdearla.workshop.service

import com.nerdearla.workshop.dto.payment.PaymentMethodData
import com.nerdearla.workshop.dto.buyer.paymentMethod.BuyerPaymentMethod
import com.nerdearla.workshop.validator.PaymentMethodValidator
import org.springframework.stereotype.Service

@Service
class PaymentMethodService(
    private val validator: PaymentMethodValidator
) {
    // TODO: implement
    fun authorize(paymentMethodData: PaymentMethodData) = BuyerPaymentMethod(
        id = "1",
        enabled = true,
        securityCode = "123",
        token = "fdflfdlsfksdjfaaAAAA"
    ).also {
        validator.validate(
            buyerPaymentMethod = it,
            paymentMethodData = paymentMethodData
        )
    }
}
