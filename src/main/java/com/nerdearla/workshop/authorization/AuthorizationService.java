package com.nerdearla.workshop.authorization;

import com.nerdearla.workshop.authorization.client.AuthorizationClient;
import com.nerdearla.workshop.operation.PaymentOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public AuthorizationService(@Autowired AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    // TODO: implement mappers
    public PaymentAuthorization authorize(PaymentOperation operation) {
        PaymentAuthorizationResponse response = authorizationClient.authorize(new PaymentAuthorizationRequest());
        return new PaymentAuthorization();
    }
}
