package com.nerdearla.workshop.mapper

import com.nerdearla.workshop.dto.payment.PaymentResponse
import com.nerdearla.workshop.model.Payment
import org.springframework.stereotype.Component

@Component
class PaymentResponseMapper {
    fun map(processPayment: Payment?): PaymentResponse {
        return PaymentResponse()
    }
}
