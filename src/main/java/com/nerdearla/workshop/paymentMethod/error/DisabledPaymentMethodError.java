package com.nerdearla.workshop.paymentMethod.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DisabledPaymentMethodError extends ResponseStatusException {

    public DisabledPaymentMethodError() {
        super(HttpStatus.UNPROCESSABLE_ENTITY, "Payment method disabled");
    }
}
