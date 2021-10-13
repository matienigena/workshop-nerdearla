package com.nerdearla.workshop.service;

import com.nerdearla.workshop.client.PaymentMethodClient;
import com.nerdearla.workshop.dto.payment.PaymentMethodData;
import com.nerdearla.workshop.model.BuyerPaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodService {

    private final PaymentMethodClient paymentMethodClient;

    public PaymentMethodService(@Autowired PaymentMethodClient paymentMethodClient) {
        this.paymentMethodClient = paymentMethodClient;
    }

    public BuyerPaymentMethod getBy(String buyerId, PaymentMethodData paymentMethodData) {
        return paymentMethodClient.get(buyerId, paymentMethodData.getToken());
    }
}
