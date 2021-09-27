package com.nerdearla.workshop.service

import com.nerdearla.workshop.model.FullOperation
import com.nerdearla.workshop.model.PaymentAuthorization
import com.nerdearla.workshop.model.PaymentOperation
import org.springframework.stereotype.Service

@Service
class GatewayService {
    // Ver de meter alguna estrategia o factory dependiendo del tipo de pago?
    // De eso se encargaría el gateway real pero bueno
    fun authorize(operation: FullOperation): PaymentAuthorization {
        return PaymentAuthorization(id = "1", traceNumber = "123")
    }
}