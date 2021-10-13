package com.nerdearla.workshop.user.buyer.validator;

import com.nerdearla.workshop.user.buyer.Buyer;
import com.nerdearla.workshop.user.buyer.client.DisabledBuyerError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BuyerValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuyerValidator.class);

    public void validate(Buyer buyer) {
        validateIsEnabled(buyer);
    }

    private void validateIsEnabled(Buyer buyer) {
        if (!buyer.getEnabled()) {
            LOGGER.error("buyer {} is disabled", buyer.getId());
            throw new DisabledBuyerError();
        }
        LOGGER.info("buyer {} is enabled", buyer.getId());
    }

}
