package com.nerdearla.workshop.user.buyer.client

import com.nerdearla.workshop.shared.client.Client
import com.nerdearla.workshop.shared.utils.CompanionLogger
import com.nerdearla.workshop.user.buyer.Buyer
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class BuyerClient(
    webClient: WebClient
) : Client(webClient) {

    override val path = "/buyers/{buyerId}"

    fun getBy(id: String): Buyer =
        get(Buyer::class.java, id)
            .log { info("buyer found: {}", it) }

    override fun handleError(response: ClientResponse): Mono<Throwable> =
        Mono.error<Throwable>(BuyerRetrievingError())
            .log { error("Error while communicating with buyer service, {}", response) }

    companion object : CompanionLogger()
}
