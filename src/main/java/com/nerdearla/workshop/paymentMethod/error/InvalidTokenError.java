package com.nerdearla.workshop.paymentMethod.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidTokenError extends ResponseStatusException {

    public InvalidTokenError() {
        super(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid token");
    }
}
