package com.nerdearla.workshop.service

import com.nerdearla.workshop.dto.buyer.Buyer
import com.nerdearla.workshop.validator.BuyerValidator
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class BuyerService(
    private val validator: BuyerValidator,
    private val webClient: WebClient
) {
    fun findBuyer(buyerId: String, identification: String, gender: String): Buyer =
        webClient
            .getBuyerById(buyerId)
            .validate(identification, gender)

    private fun Buyer.validate(identification: String, gender: String) =
        also { validator.validate(this, identification, gender) }

    // TODO: Ver si vale la pena armar una capita generica que abstraiga el webclient de los services
    private fun WebClient.getBuyerById(buyerId: String) =
        get()
            .uri { uriBuilder ->
                uriBuilder
                    .path("/buyers/{buyerId}")
                    .build(buyerId)
            }
            .retrieve().bodyToMono(Buyer::class.java).block()!!
}
