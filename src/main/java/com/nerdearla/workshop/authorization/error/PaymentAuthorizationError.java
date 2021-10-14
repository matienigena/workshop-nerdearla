package com.nerdearla.workshop.authorization.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PaymentAuthorizationError extends ResponseStatusException {

    public PaymentAuthorizationError() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "Error while authorizing operation");
    }
}
