package com.nerdearla.workshop.service;

import com.nerdearla.workshop.dto.payment.PaymentMethodData;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodService {

    public com.nerdearla.workshop.model.PaymentMethod authorize(PaymentMethodData paymentMethod) {
        return new com.nerdearla.workshop.model.PaymentMethod();
    }
}
