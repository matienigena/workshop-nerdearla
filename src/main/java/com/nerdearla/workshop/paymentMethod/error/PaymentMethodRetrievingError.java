package com.nerdearla.workshop.paymentMethod.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PaymentMethodRetrievingError extends ResponseStatusException {

    public PaymentMethodRetrievingError() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "Error while retrieving payment method");
    }
}
