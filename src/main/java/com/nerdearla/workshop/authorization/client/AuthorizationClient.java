package com.nerdearla.workshop.authorization.client;

import com.nerdearla.workshop.authorization.error.PaymentAuthorizationError;
import com.nerdearla.workshop.shared.client.PostClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class AuthorizationClient extends PostClient<PaymentAuthorizationResponse, PaymentAuthorizationRequest> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationClient.class);

    public AuthorizationClient(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    protected Mono<Throwable> handleError(ClientResponse response) {
        LOGGER.error("Error while communicating with authorization service, {}", response);
        return Mono.error(new PaymentAuthorizationError());
    }

    @Override
    protected String getPath() {
        return "/authorizations";
    }

    public PaymentAuthorizationResponse authorize(PaymentAuthorizationRequest paymentAuthorizationRequest) {
        return post(PaymentAuthorizationResponse.class, PaymentAuthorizationRequest.class, paymentAuthorizationRequest);
    }
}
