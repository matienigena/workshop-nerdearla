package com.nerdearla.workshop.service;

import com.nerdearla.workshop.client.BuyerClient;
import com.nerdearla.workshop.model.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    private final BuyerClient buyerClient;

    public BuyerService(@Autowired BuyerClient buyerClient) {
        this.buyerClient = buyerClient;
    }

    public Buyer findBuyer(String buyerId) {
        return buyerClient.getById(buyerId);
    }
}