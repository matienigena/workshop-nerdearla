package com.nerdearla.workshop.payment.mapper;

import com.nerdearla.workshop.payment.model.Payment;
import com.nerdearla.workshop.payment.PaymentResponse;
import org.springframework.stereotype.Component;

@Component
public class PaymentResponseMapper {

    public PaymentResponse map(Payment payment) {
        return new PaymentResponse(payment.getPaymentId());
    }
}
