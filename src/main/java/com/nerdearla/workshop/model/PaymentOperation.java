package com.nerdearla.workshop.model;

import com.nerdearla.workshop.dto.payment.PaymentRequest;

public class PaymentOperation {

    private String paymentId;

    private String qrId;

    private Buyer buyer;

    private Seller seller;

    private PaymentOperation(){}


    public class Builder {

        private Long buyerId;



        public Builder fromPaymentRequest(PaymentRequest paymentRequest) {

        }

        public PaymentOperation build() {
            PaymentOperation paymentOperation = new PaymentOperation();
            return paymentOperation;
        }
    }
}
