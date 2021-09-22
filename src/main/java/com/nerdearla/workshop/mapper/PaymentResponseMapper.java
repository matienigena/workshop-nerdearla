package com.nerdearla.workshop.mapper;

import com.nerdearla.workshop.dto.payment.PaymentResponse;
import com.nerdearla.workshop.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentResponseMapper {

    public PaymentResponse map(Payment processPayment) {
        return new PaymentResponse();
    }
}
