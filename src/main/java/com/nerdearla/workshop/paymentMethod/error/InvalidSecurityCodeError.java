package com.nerdearla.workshop.paymentMethod.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidSecurityCodeError extends ResponseStatusException {

    public InvalidSecurityCodeError() {
        super(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid security code");
    }
}
