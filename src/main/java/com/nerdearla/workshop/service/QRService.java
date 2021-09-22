package com.nerdearla.workshop.service;

import com.nerdearla.workshop.model.QR;
import org.springframework.stereotype.Service;

@Service
public class QRService {

    // Llamada a service externo
    public QR findValidQR(String qrId) {
        return new QR();
    }
}
