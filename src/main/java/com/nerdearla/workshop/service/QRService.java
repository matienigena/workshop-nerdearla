package com.nerdearla.workshop.service;

import com.nerdearla.workshop.client.QRClient;
import com.nerdearla.workshop.model.QR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QRService {

    private final QRClient qrClient;

    public QRService(@Autowired QRClient qrClient) {
        this.qrClient = qrClient;
    }

    // Llamada a service externo
    public QR findValidQR(String qrId) {
        return qrClient.getById(qrId);
    }
}
