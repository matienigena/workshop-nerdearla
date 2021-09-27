package com.nerdearla.workshop.repository

import com.nerdearla.workshop.model.Payment
import org.springframework.stereotype.Repository

@Repository
class PaymentRepository {
    fun save(payment: Payment?) {}
}
