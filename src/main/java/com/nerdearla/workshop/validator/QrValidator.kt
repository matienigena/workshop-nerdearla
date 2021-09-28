package com.nerdearla.workshop.validator

import com.nerdearla.workshop.dto.qr.QR
import org.springframework.stereotype.Component

@Component
class QrValidator {

    fun validate(qr: QR) {
        when {
            !qr.enabled -> throw RuntimeException("QR is not enabled")
        }
    }
}