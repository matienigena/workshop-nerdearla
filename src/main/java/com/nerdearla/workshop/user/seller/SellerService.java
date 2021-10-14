package com.nerdearla.workshop.user.seller;

import com.nerdearla.workshop.user.seller.client.SellerClient;
import com.nerdearla.workshop.user.seller.validator.SellerValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SellerService.class);

    private final SellerClient client;
    private final SellerValidator validator;

    public SellerService(SellerClient client, SellerValidator validator) {
        this.client = client;
        this.validator = validator;
    }

    public Seller findSeller(String sellerId) {
        Seller seller = client.getById(sellerId);
        validator.validate(seller);
        LOGGER.info("Seller {} validated", seller.getId());
        return seller;
    }
}
