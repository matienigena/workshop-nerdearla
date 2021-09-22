package com.nerdearla.workshop.service;

import com.nerdearla.workshop.dto.payment.PaymentResponse;
import com.nerdearla.workshop.model.PaymentOperation;
import com.nerdearla.workshop.model.User;
import org.springframework.stereotype.Service;

@Service
public class PaymentsService {

    private final PaymentIdProvider paymentIdProvider;
    private final UserService userService;
    private final PaymentMethodService paymentMethodService;
    private final FraudService fraudService;
    private final GatewayService gatewayService;
    private final BuyerService buyerService;
    private final SellerService sellerService;

    public PaymentsService(
            PaymentIdProvider paymentIdProvider,
            UserService userService,
            PaymentMethodService paymentMethodService,
            FraudService fraudService,
            GatewayService gatewayService,
            BuyerService buyerService,
            SellerService sellerService
    ) {
        this.paymentIdProvider = paymentIdProvider;
        this.userService = userService;
        this.paymentMethodService = paymentMethodService;
        this.fraudService = fraudService;
        this.gatewayService = gatewayService;
        this.buyerService = buyerService;
        this.sellerService = sellerService;
    }

    public PaymentResponse processPayment(PaymentOperation operation) {
        String id = paymentIdProvider.getNext();
        operation.setPaymentId(id);

        // validar qr_id?

        // validar amount e installments?

        User buyer = userService.findValidUser(operation.getPaymentRequest().getBuyerId());
        operation.setBuyer(buyerService.findBuyer(buyer.getId()));

        // Obtener paymentMethod y agregarlo a operation?
        paymentMethodService.authorize(operation.getPaymentRequest().getPaymentMethod());

        User seller = userService.findValidUser(operation.getPaymentRequest().getSellerId());
        operation.setSeller(sellerService.findSeller(seller.getId()));

        fraudService.authorize(operation);

        gatewayService.authorize(operation);

        return new PaymentResponse();
    }
}
