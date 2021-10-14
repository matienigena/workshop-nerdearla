package com.nerdearla.workshop.user.buyer;

import com.nerdearla.workshop.user.buyer.client.BuyerClient;
import com.nerdearla.workshop.user.buyer.validator.BuyerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    private final BuyerClient client;
    private final BuyerValidator validator;

    public BuyerService(BuyerClient client, BuyerValidator validator) {
        this.client = client;
        this.validator = validator;
    }

    public Buyer findBuyer(String buyerId) {
        Buyer buyer = client.getById(buyerId);
        validator.validate(buyer);
        return buyer;
    }
}