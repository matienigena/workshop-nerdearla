package com.nerdearla.workshop.service

import com.nerdearla.workshop.model.Buyer
import org.springframework.stereotype.Service

@Service
class BuyerService {
    // Llamada a service externo
    fun findBuyer(buyerId: String?): Buyer {
        return Buyer(buyerId!!)
    }
}
