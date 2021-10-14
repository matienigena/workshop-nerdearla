package com.nerdearla.workshop.authorization.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PaymentNotAuthorizedError extends ResponseStatusException {

    public PaymentNotAuthorizedError() {
        super(HttpStatus.UNPROCESSABLE_ENTITY, "Payment not authorized");
    }
}
