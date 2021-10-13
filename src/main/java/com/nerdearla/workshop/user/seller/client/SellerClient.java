package com.nerdearla.workshop.user.seller.client;

import com.nerdearla.workshop.shared.client.GetClient;
import com.nerdearla.workshop.user.seller.Seller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class SellerClient extends GetClient<Seller> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SellerClient.class);

    public SellerClient(WebClient webClient) {
        this.webClient = webClient;
    }

    // TODO: add exception
    @Override
    protected Mono<Throwable> handleError(ClientResponse clientResponse) {
        LOGGER.error("Error while communicating with seller service, {}", clientResponse);
        return Mono.error(new RuntimeException());
    }

    @Override
    protected String getPath() {
        return "/sellers/{sellerId}";
    }

    public Seller getById(String id) {
        Seller seller = get(Seller.class, id);
        LOGGER.info("Seller found: {}", seller);
        return seller;
    }
}
