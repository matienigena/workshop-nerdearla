package com.nerdearla.workshop.service

import com.nerdearla.workshop.model.PaymentOperation
import org.springframework.stereotype.Service

@Service
class GatewayService {
    fun authorize(operation: PaymentOperation?) {}
}