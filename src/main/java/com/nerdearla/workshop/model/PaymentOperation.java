package com.nerdearla.workshop.model;

import com.nerdearla.workshop.dto.payment.PaymentRequest;

public class PaymentOperation {

    private final PaymentRequest paymentRequest;
    private String paymentId;
    private QR qr;
    private Buyer buyer;
    private Seller seller;
    private BuyerPaymentMethod buyerPaymentMethod;

    public PaymentOperation(PaymentRequest paymentRequest) {
        this.paymentRequest = paymentRequest;
    }

    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public BuyerPaymentMethod getPaymentMethod() {
        return buyerPaymentMethod;
    }

    public void setPaymentMethod(BuyerPaymentMethod buyerPaymentMethod) {
        this.buyerPaymentMethod = buyerPaymentMethod;
    }

    public QR getQr() {
        return qr;
    }

    public void setQr(QR qr) {
        this.qr = qr;
    }
}
