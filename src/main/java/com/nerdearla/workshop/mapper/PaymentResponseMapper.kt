package com.nerdearla.workshop.mapper

import com.nerdearla.workshop.dto.payment.PaymentResponse
import com.nerdearla.workshop.model.Payment
import org.springframework.stereotype.Component

@Component
class PaymentResponseMapper {

    fun map(payment: Payment): PaymentResponse {
        return PaymentResponse(
            paymentId = payment.id
        )
    }

}
