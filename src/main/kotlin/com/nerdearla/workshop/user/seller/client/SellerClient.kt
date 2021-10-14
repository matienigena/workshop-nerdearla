package com.nerdearla.workshop.user.seller.client

import com.nerdearla.workshop.shared.client.Client
import com.nerdearla.workshop.shared.utils.CompanionLogger
import com.nerdearla.workshop.user.seller.Seller
import com.nerdearla.workshop.user.seller.error.SellerRetrievingError
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class SellerClient(
    webClient: WebClient
) : Client(webClient) {

    override val path = "/sellers/{sellerId}"

    fun getBy(id: String): Seller =
        get(Seller::class.java, id)
            .log { info("seller found: {}", it) }

    override fun handleError(response: ClientResponse): Mono<Throwable> =
        Mono.error<Throwable>(SellerRetrievingError())
            .log { error("Error while communicating with seller service, {}", response) }

    companion object : CompanionLogger()
}
