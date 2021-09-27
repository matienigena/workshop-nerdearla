package com.nerdearla.workshop.service

import com.nerdearla.workshop.dto.payment.PaymentMethodData
import com.nerdearla.workshop.model.PaymentMethod
import com.nerdearla.workshop.validator.PaymentMethodValidator
import org.springframework.stereotype.Service

@Service
class PaymentMethodService (
    private val validator: PaymentMethodValidator
) {
    // TODO: implement
    fun authorize(paymentMethodData: PaymentMethodData) =
        PaymentMethod(id = "1", enabled = true).also {
            validator.validate(
                paymentMethod = it,
                paymentMethodData = paymentMethodData
            )
        }
}
