package com.nerdearla.workshop.service

import com.nerdearla.workshop.dto.seller.Seller
import com.nerdearla.workshop.validator.SellerValidator
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class SellerService(
    private val validator: SellerValidator,
    private val webClient: WebClient
) {
    fun findSeller(sellerId: String) =
        webClient
            .getSellerById(sellerId)
        .also {
            validator.validate(it)
        }

    private fun WebClient.getSellerById(sellerId: String) =
        get()
            .uri { uriBuilder ->
                uriBuilder
                    .path("/sellers/{sellerId}")
                    .build(sellerId)
            }
            .retrieve().bodyToMono(Seller::class.java).block()!!
}


