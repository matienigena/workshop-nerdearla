package com.nerdearla.workshop.service

import org.springframework.stereotype.Service
import java.util.*

@Service
class PaymentIdProvider {
    val next: String
        get() = UUID.randomUUID().toString()
}
