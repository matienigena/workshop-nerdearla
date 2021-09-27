package com.nerdearla.workshop.service

import com.nerdearla.workshop.model.QR
import org.springframework.stereotype.Service

@Service
class QRService {
    // Llamada a service externo
    fun findValidQR(qrId: String?) =
        QR(id = "1")
}
