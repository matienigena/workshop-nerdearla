package com.nerdearla.workshop.user.buyer.client;

import com.nerdearla.workshop.shared.client.GetClient;
import com.nerdearla.workshop.user.buyer.Buyer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class BuyerClient extends GetClient<Buyer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuyerClient.class);

    public BuyerClient(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    protected Mono<Throwable> handleError(ClientResponse clientResponse) {
        LOGGER.error("Error while communicating with buyer service, {}", clientResponse);
        return Mono.error(new BuyerRetrievingError());
    }

    @Override
    protected String getPath() {
        return "/buyers/{buyerId}";
    }

    public Buyer getById(String id) {
        Buyer buyer = get(Buyer.class, id);
        LOGGER.info("Buyer found: {}", buyer);
        return buyer;
    }
}
