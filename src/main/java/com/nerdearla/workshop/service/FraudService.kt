package com.nerdearla.workshop.service

import com.nerdearla.workshop.model.FullOperation
import com.nerdearla.workshop.model.PaymentOperation
import org.springframework.stereotype.Service

@Service
class FraudService {
    fun authorize(fullOperation: FullOperation) {}
}
