package com.nerdearla.workshop.service;

import com.nerdearla.workshop.model.Buyer;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    // Llamada a service externo
    public Buyer findBuyer(String buyerId) {
        return new Buyer();
    }
}