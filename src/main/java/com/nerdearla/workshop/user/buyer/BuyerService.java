package com.nerdearla.workshop.user.buyer;

import com.nerdearla.workshop.user.buyer.client.BuyerClient;
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