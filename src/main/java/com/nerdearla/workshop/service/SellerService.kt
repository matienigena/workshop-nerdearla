package com.nerdearla.workshop.service

import com.nerdearla.workshop.model.Seller
import org.springframework.stereotype.Service

@Service
class SellerService {
    // Llamada a service externo
    fun findSeller(sellerId: String?): Seller {
        return Seller( sellerId = "1")
    }
}
