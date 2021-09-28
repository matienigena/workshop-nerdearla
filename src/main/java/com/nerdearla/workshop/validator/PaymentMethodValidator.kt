package com.nerdearla.workshop.validator

import com.nerdearla.workshop.dto.payment.PaymentMethodData
import com.nerdearla.workshop.dto.buyer.paymentMethod.BuyerPaymentMethod
import org.springframework.stereotype.Component

@Component
interface PaymentMethodValidator {

    fun validate(buyerPaymentMethod: BuyerPaymentMethod, paymentMethodData: PaymentMethodData) {
        when {
            !buyerPaymentMethod.enabled -> throwDisabledPaymentMethod()
            tokenAndSecurityCodeDoesntMatch(buyerPaymentMethod, paymentMethodData) -> throwInvalidPaymentMethod()
        }
    }

    private fun tokenAndSecurityCodeDoesntMatch(
        buyerPaymentMethod: BuyerPaymentMethod,
        paymentMethodData: PaymentMethodData
    ) = (buyerPaymentMethod.token != paymentMethodData.token ||
            buyerPaymentMethod.securityCode != paymentMethodData.securityCode)

    private fun throwDisabledPaymentMethod() {
        throw RuntimeException("PaymentMethod is not enabled").also {
            // TODO: logging
        }
    }

    private fun throwInvalidPaymentMethod() {
        throw RuntimeException("Payment method is not correct").also {
            // TODO: logging
        }
    }
}