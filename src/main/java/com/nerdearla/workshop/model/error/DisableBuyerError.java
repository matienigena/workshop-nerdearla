package com.nerdearla.workshop.model.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DisableBuyerError extends ResponseStatusException {

    public DisableBuyerError() {
        super(HttpStatus.UNPROCESSABLE_ENTITY, "buyer disabled");
    }
}
