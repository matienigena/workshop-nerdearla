package com.nerdearla.workshop.paymentMethod;

import com.nerdearla.workshop.paymentMethod.client.PaymentMethodClient;
import com.nerdearla.workshop.payment.model.PaymentMethodData;
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
