package com.nerdearla.workshop.client;

import com.nerdearla.workshop.model.BuyerPaymentMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PaymentMethodClient extends Client<BuyerPaymentMethod> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentMethodClient.class);

    public PaymentMethodClient(WebClient webClient) {
        this.webClient = webClient;
    }

    // TODO: add exception
    @Override
    protected Mono<Throwable> handleError(ClientResponse clientResponse) {
        LOGGER.error("Error while communicating with paymentMethod service, {}", clientResponse);
        return Mono.error(new RuntimeException());
    }

    @Override
    protected String getPath() {
        return "/buyers/{buyerId}/paymentMethods/token/{paymentMethodToken}";
    }

    public BuyerPaymentMethod get(String buyerId, String token) {
        BuyerPaymentMethod buyerPaymentMethod = get(BuyerPaymentMethod.class, buyerId, token);
        LOGGER.info("PaymentMethod found: {}", buyerPaymentMethod);
        return buyerPaymentMethod;
    }
}
