package com.nerdearla.workshop.service;

import com.nerdearla.workshop.dto.payment.PaymentMethod;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodService {

    public com.nerdearla.workshop.model.PaymentMethod authorize(PaymentMethod paymentMethod) {
        return new com.nerdearla.workshop.model.PaymentMethod();
    }
}
