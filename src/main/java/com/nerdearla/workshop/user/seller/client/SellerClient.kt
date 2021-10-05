package com.nerdearla.workshop.user.seller.client

import com.nerdearla.workshop.shared.client.Client
import com.nerdearla.workshop.user.seller.Seller
import com.nerdearla.workshop.user.seller.error.SellerRetrievingError
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono
import java.net.URI

@Component
class SellerClient(
    webClient: WebClient
) : Client(webClient) {

    fun getBy(id: String): Seller =
        get<Seller>(id)
            .log { info("seller found: {}", it) }

    override fun uri(vararg args: String): URI =
        UriComponentsBuilder
            .fromPath(path)
            .build(args)

    override fun handleError(response: ClientResponse): Mono<Throwable> =
        Mono.error<Throwable>(SellerRetrievingError())
            .log { error("Error while communicating with seller service, {}", response) }

    companion object : CompanionLogger() {
        private const val path = "/sellers/{sellerId}"
    }
}
