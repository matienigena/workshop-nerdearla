package com.nerdearla.workshop.service;

import com.nerdearla.workshop.model.Seller;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    public Seller findSeller(String sellerId) {
        return new Seller();
    }
}
