package com.nerdearla.workshop.service;

import com.nerdearla.workshop.dto.payment.PaymentRequest;
import com.nerdearla.workshop.dto.payment.PaymentResponse;
import com.nerdearla.workshop.model.PaymentOperation;
import org.springframework.stereotype.Service;

@Service
public class PaymentsService {

    private final PaymentIdProvider paymentIdProvider;
    private final UserService userService;
    private final PaymentMethodService paymentMethodService;
    private final FraudService fraudService;
    private final GatewayService gatewayService;

    public PaymentsService(
            PaymentIdProvider paymentIdProvider,
            UserService userService,
            PaymentMethodService paymentMethodService,
            FraudService fraudService,
            GatewayService gatewayService
    ) {
        this.paymentIdProvider = paymentIdProvider;
        this.userService = userService;
        this.paymentMethodService = paymentMethodService;
        this.fraudService = fraudService;
        this.gatewayService = gatewayService;
    }

    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        String id = paymentIdProvider.getNext();

        userService.findValidUser(paymentRequest.getBuyerId());

        paymentMethodService.authorize(paymentRequest.getPaymentMethod());

        userService.findValidUser(paymentRequest.getSellerId());

        PaymentOperation operation = new PaymentOperation();

        // Validar Fraude
        fraudService.authorize(operation);

        // Llamar a NotDecidir
        gatewayService.authorize(operation);

        return new PaymentResponse();
    }
}
