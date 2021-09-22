package com.nerdearla.workshop.model;

public class Payment {

    private final String paymentId;
    private final String authorizationId;
    private final String traceNumber;
    private final String qrId;
    private final String paymentMethodId;
    private final Double amount;
    private final String buyerId;
    private final String sellerId;

    public Payment(PaymentBuilder builder) {
        this.paymentId = builder.paymentId;
        this.authorizationId = builder.authorizationId;
        this.traceNumber = builder.traceNumber;
        this.qrId = builder.qrId;
        this.paymentMethodId = builder.paymentMethodId;
        this.amount = builder.amount;
        this.buyerId = builder.buyerId;
        this.sellerId = builder.sellerId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getAuthorizationId() {
        return authorizationId;
    }

    public String getTraceNumber() {
        return traceNumber;
    }

    public String getQrId() {
        return qrId;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public Double getAmount() {
        return amount;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public static class PaymentBuilder {

        private final String paymentId;
        private final String authorizationId;
        private final String traceNumber;
        private final String qrId;
        private final String paymentMethodId;
        private final String sellerId;
        private final String buyerId;
        private final Double amount;

        public PaymentBuilder(PaymentOperation operation, PaymentAuthorization authorization) {
            this.paymentId = operation.getPaymentId();
            this.authorizationId = authorization.getId();
            this.traceNumber = operation.getPaymentRequest().getTerminalData().getTraceNumber();
            this.qrId = operation.getQr().getQrId();
            this.paymentMethodId = operation.getPaymentMethod().getPaymentMethodId();
            this.buyerId = operation.getBuyer().getBuyerId();
            this.sellerId = operation.getSeller().getSellerId();
            this.amount = operation.getPaymentRequest().getAmount();
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
