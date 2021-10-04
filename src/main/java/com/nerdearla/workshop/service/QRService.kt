package com.nerdearla.workshop.service

import com.nerdearla.workshop.dto.qr.QR
import com.nerdearla.workshop.validator.QrValidator
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class QRService(
    private val validator: QrValidator,
    private val webClient: WebClient
) {
    // Llamada a service externo
    fun findValidQR(qrId: String) =
        webClient
            .findQRById(qrId)
            .also {
                validator.validate(it)
            }

    private fun WebClient.findQRById(qrId: String) =
        get()
        .uri { uriBuilder ->
            uriBuilder
                .path("/qrs/{qrId}")
                .build(qrId)
        }
        .retrieve().bodyToMono(QR::class.java).block()!!
}
