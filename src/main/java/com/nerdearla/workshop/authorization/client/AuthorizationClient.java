package com.nerdearla.workshop.authorization.client;

import com.nerdearla.workshop.authorization.PaymentAuthorizationRequest;
import com.nerdearla.workshop.authorization.PaymentAuthorizationResponse;
import com.nerdearla.workshop.shared.client.PostClient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

@Component
public class AuthorizationClient extends PostClient<PaymentAuthorizationResponse, PaymentAuthorizationRequest> {

    // TODO: exception
    @Override
    protected Mono<Throwable> handleError(ClientResponse clientResponse) {
        return Mono.error(new RuntimeException());
    }

    @Override
    protected String getPath() {
        return "/authorizations";
    }

    public PaymentAuthorizationResponse authorize(PaymentAuthorizationRequest paymentAuthorizationRequest) {
        return post(PaymentAuthorizationResponse.class, PaymentAuthorizationRequest.class, paymentAuthorizationRequest);
    }
}
