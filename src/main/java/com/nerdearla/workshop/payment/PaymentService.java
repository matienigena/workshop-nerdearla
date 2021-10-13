package com.nerdearla.workshop.payment;

import com.nerdearla.workshop.authorization.PaymentAuthorization;
import com.nerdearla.workshop.operation.PaymentOperation;
import com.nerdearla.workshop.payment.model.Payment;
import com.nerdearla.workshop.payment.provider.PaymentIdProvider;
import com.nerdearla.workshop.payment.repository.PaymentRepository;
import com.nerdearla.workshop.paymentMethod.BuyerPaymentMethod;
import com.nerdearla.workshop.paymentMethod.PaymentMethodService;
import com.nerdearla.workshop.authorization.AuthorizationService;
import com.nerdearla.workshop.user.buyer.Buyer;
import com.nerdearla.workshop.user.buyer.BuyerService;
import com.nerdearla.workshop.qr.QR;
import com.nerdearla.workshop.qr.QRService;
import com.nerdearla.workshop.user.seller.Seller;
import com.nerdearla.workshop.user.seller.SellerService;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentIdProvider paymentIdProvider;
    private final PaymentMethodService paymentMethodService;
    private final AuthorizationService gatewayService;
    private final BuyerService buyerService;
    private final SellerService sellerService;
    private final QRService qrService;
    private final PaymentRepository paymentRepository;

    public PaymentService(
            PaymentIdProvider paymentIdProvider,
            PaymentMethodService paymentMethodService,
            AuthorizationService gatewayService,
            BuyerService buyerService,
            SellerService sellerService,
            PaymentRepository paymentRepository,
            QRService qrService
    ) {
        this.paymentIdProvider = paymentIdProvider;
        this.paymentMethodService = paymentMethodService;
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

        Buyer buyer = buyerService.findBuyer(operation.getPaymentRequest().getBuyerId());
        operation.setBuyer(buyer);

        // Obtener paymentMethod y agregarlo a operation?
        BuyerPaymentMethod buyerPaymentMethod = paymentMethodService.getBy(buyer.getId(), operation.getPaymentRequest().getPaymentMethodData());
        operation.setPaymentMethod(buyerPaymentMethod);

        Seller seller = sellerService.findSeller(operation.getPaymentRequest().getSellerId());
        operation.setSeller(seller);

        PaymentAuthorization authorization = gatewayService.authorize(operation);

        Payment payment = new Payment.PaymentBuilder(operation, authorization).build();
        paymentRepository.save(payment);

        return payment;
    }
}
