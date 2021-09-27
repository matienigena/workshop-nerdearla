package com.nerdearla.workshop.service

import com.nerdearla.workshop.dto.payment.PaymentMethodData
import com.nerdearla.workshop.model.PaymentMethod
import org.springframework.stereotype.Service

@Service
class PaymentMethodService {
    // TODO: implement
    fun authorize(paymentMethodData: PaymentMethodData): PaymentMethod = PaymentMethod(paymentMethodId = "1")
}
