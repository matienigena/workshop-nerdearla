package com.nerdearla.workshop.validator

import com.nerdearla.workshop.dto.payment.PaymentMethodData
import com.nerdearla.workshop.model.PaymentMethod
import org.springframework.stereotype.Component

@Component
class PaymentMethodValidator {

    fun validate(paymentMethod: PaymentMethod, paymentMethodData: PaymentMethodData) {}
}