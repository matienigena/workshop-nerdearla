package com.nerdearla.workshop.authorization;

import com.nerdearla.workshop.operation.PaymentOperation;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    // Ver de meter alguna estrategia o factory dependiendo del tipo de pago?
    // De eso se encargaría el gateway real pero bueno
    public PaymentAuthorization authorize(PaymentOperation operation) {
        return new PaymentAuthorization();
    }
}
