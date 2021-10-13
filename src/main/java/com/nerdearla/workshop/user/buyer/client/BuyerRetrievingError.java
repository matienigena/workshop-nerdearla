package com.nerdearla.workshop.user.buyer.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BuyerRetrievingError extends ResponseStatusException {

    public BuyerRetrievingError() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "Error while retrieving buyer");
    }
}
