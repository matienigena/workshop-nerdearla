package com.nerdearla.workshop.paymentMethod;

import com.nerdearla.workshop.payment.model.PaymentMethodData;
import com.nerdearla.workshop.paymentMethod.client.PaymentMethodClient;
import com.nerdearla.workshop.paymentMethod.validator.PaymentMethodValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentMethodService.class);

    private final PaymentMethodClient client;
    private final PaymentMethodValidator validator;

    public PaymentMethodService(
            @Autowired PaymentMethodClient client,
            @Autowired PaymentMethodValidator validator) {
        this.client = client;
        this.validator = validator;
    }

    public BuyerPaymentMethod getBy(String buyerId, PaymentMethodData paymentMethodData) {
        BuyerPaymentMethod buyerPaymentMethod = client.get(buyerId, paymentMethodData.getToken());
        validate(buyerPaymentMethod, paymentMethodData);
        return buyerPaymentMethod;
    }

    private void validate(BuyerPaymentMethod buyerPaymentMethod, PaymentMethodData paymentMethodData) {
        validator.validate(buyerPaymentMethod, paymentMethodData);
        LOGGER.info("BuyerPaymentMethod {} validated successfully", buyerPaymentMethod.getId());
    }
}
