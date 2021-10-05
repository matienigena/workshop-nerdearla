package com.nerdearla.workshop.user.buyer.client

import com.nerdearla.workshop.user.buyer.Buyer
import com.nerdearla.workshop.shared.client.Client
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono
import java.net.URI

@Component
class BuyerClient(
    webClient: WebClient
) : Client(webClient) {

    fun getBy(id: String): Buyer =
        get<Buyer>(id)
            .log { info("buyer found: {}", it) }

    override fun uri(vararg args: String): URI =
        UriComponentsBuilder
            .fromPath(path)
            .build(args)

    override fun handleError(response: ClientResponse): Mono<Throwable> =
        Mono.error<Throwable>(BuyerRetrievingError())
            .log { error("Error while communicating with buyer service, {}", response) }

    companion object : CompanionLogger() {
        private const val path = "/buyers/{buyerId}"
    }
}
