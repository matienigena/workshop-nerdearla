package com.nerdearla.workshop.service

import com.nerdearla.workshop.dto.qr.QR
import org.springframework.stereotype.Service

@Service
class QRService {
    // Llamada a service externo
    fun findValidQR(qrId: String?) = QR(
        id = "1",
        enabled = true
    )
}
