package com.nerdearla.workshop.qr.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DisabledQrError extends ResponseStatusException {

    public DisabledQrError() {
        super(HttpStatus.UNPROCESSABLE_ENTITY, "QR Disabled");
    }
}
