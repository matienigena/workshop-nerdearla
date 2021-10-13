package com.nerdearla.workshop.service;

import com.nerdearla.workshop.client.SellerClient;
import com.nerdearla.workshop.model.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    private final SellerClient sellerClient;

    public SellerService(@Autowired SellerClient sellerClient) {
        this.sellerClient = sellerClient;
    }

    // Llamada a service externo
    public Seller findSeller(String sellerId) {
        return sellerClient.getById(sellerId);
    }
}
