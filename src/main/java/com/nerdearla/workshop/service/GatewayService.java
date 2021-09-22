package com.nerdearla.workshop.service;

import com.nerdearla.workshop.model.PaymentAuthorization;
import com.nerdearla.workshop.model.PaymentOperation;
import org.springframework.stereotype.Service;

@Service
public class GatewayService {
    public PaymentAuthorization authorize(PaymentOperation operation) {
        return new PaymentAuthorization();
    }
}
