package com.nerdearla.workshop.service;

import com.nerdearla.workshop.model.*;
import com.nerdearla.workshop.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentIdProvider paymentIdProvider;
    private final PaymentMethodService paymentMethodService;
    private final FraudService fraudService;
    private final GatewayService gatewayService;
    private final BuyerService buyerService;
    private final SellerService sellerService;
    private final QRService qrService;
    private final PaymentRepository paymentRepository;

    public PaymentService(
            PaymentIdProvider paymentIdProvider,
            PaymentMethodService paymentMethodService,
            FraudService fraudService,
            GatewayService gatewayService,
            BuyerService buyerService,
            SellerService sellerService,
            PaymentRepository paymentRepository,
            QRService qrService
    ) {
        this.paymentIdProvider = paymentIdProvider;
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

        Buyer buyer = buyerService.findBuyer(operation.getPaymentRequest().getBuyerId());
        operation.setBuyer(buyer);

        // Obtener paymentMethod y agregarlo a operation?
        BuyerPaymentMethod buyerPaymentMethod = paymentMethodService.getBy(buyer.getId(), operation.getPaymentRequest().getPaymentMethodData());
        operation.setPaymentMethod(buyerPaymentMethod);

        Seller seller = sellerService.findSeller(operation.getPaymentRequest().getSellerId());
        operation.setSeller(seller);

        // FraudResult que se persista
        fraudService.authorize(operation);

        PaymentAuthorization authorization = gatewayService.authorize(operation);

        Payment payment = new Payment.PaymentBuilder(operation, authorization).build();
        paymentRepository.save(payment);

        return payment;
    }
}
