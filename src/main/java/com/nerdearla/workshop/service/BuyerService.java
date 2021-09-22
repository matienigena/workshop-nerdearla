package com.nerdearla.workshop.service;

import com.nerdearla.workshop.model.Buyer;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    public Buyer findBuyer(String buyerId) {
        return new Buyer();
    }
}