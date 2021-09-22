package com.nerdearla.workshop.model;

public class Payment {

    private final String paymentId;
    private final String authorizationId;

    public Payment(PaymentBuilder builder) {
        this.paymentId = builder.paymentId;
        this.authorizationId = builder.authorizationId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getAuthorizationId() {
        return authorizationId;
    }

    public static class PaymentBuilder {

        private final String paymentId;
        private final String authorizationId;

        public PaymentBuilder(PaymentOperation operation, PaymentAuthorization authorization) {
            this.paymentId = operation.getPaymentId();
            this.authorizationId = authorization.getId();
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
