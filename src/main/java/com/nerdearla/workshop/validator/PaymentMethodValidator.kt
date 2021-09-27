package com.nerdearla.workshop.validator

import com.nerdearla.workshop.dto.payment.PaymentMethodData
import com.nerdearla.workshop.model.BuyerPaymentMethod
import org.springframework.stereotype.Component

@Component
interface PaymentMethodValidator {

    fun validate(buyerPaymentMethod: BuyerPaymentMethod, paymentMethodData: PaymentMethodData) {}
}