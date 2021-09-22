package com.nerdearla.workshop.service;

import com.nerdearla.workshop.dto.payment.PaymentResponse;
import com.nerdearla.workshop.model.*;
import com.nerdearla.workshop.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentIdProvider paymentIdProvider;
    private final UserService userService;
    private final PaymentMethodService paymentMethodService;
    private final FraudService fraudService;
    private final GatewayService gatewayService;
    private final BuyerService buyerService;
    private final SellerService sellerService;
    private final QRService qrService;
    private final PaymentRepository paymentRepository;

    public PaymentService(
            PaymentIdProvider paymentIdProvider,
            UserService userService,
            PaymentMethodService paymentMethodService,
            FraudService fraudService,
            GatewayService gatewayService,
            BuyerService buyerService,
            SellerService sellerService,
            PaymentRepository paymentRepository,
            QRService qrService
    ) {
        this.paymentIdProvider = paymentIdProvider;
        this.userService = userService;
        this.paymentMethodService = paymentMethodService;
        this.fraudService = fraudService;
        this.gatewayService = gatewayService;
        this.buyerService = buyerService;
        this.sellerService = sellerService;
        this.paymentRepository = paymentRepository;
        this.qrService = qrService;
    }

    public Payment processPayment(PaymentOperation operation) {
        String id = paymentIdProvider.getNext();
        operation.setPaymentId(id);

        // validar qr_id?
        QR qr = qrService.findValidQR(operation.getPaymentRequest().getQrId());
        operation.setQr(qr);

        // validar amount e installments?

        User buyer = userService.findValidUser(operation.getPaymentRequest().getBuyerId());
        operation.setBuyer(buyerService.findBuyer(buyer.getId()));

        // Obtener paymentMethod y agregarlo a operation?
        PaymentMethod paymentMethod = paymentMethodService.authorize(operation.getPaymentRequest().getPaymentMethod());
        operation.setPaymentMethod(paymentMethod);

        User seller = userService.findValidUser(operation.getPaymentRequest().getSellerId());
        operation.setSeller(sellerService.findSeller(seller.getId()));

        // FraudResult que se persista
        fraudService.authorize(operation);

        PaymentAuthorization authorization = gatewayService.authorize(operation);

        Payment payment = new Payment.PaymentBuilder(operation, authorization).build();
        paymentRepository.save(payment);

        return payment;
    }
}
