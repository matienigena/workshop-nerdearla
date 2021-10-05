package com.nerdearla.workshop.paymentMethod.client

import com.nerdearla.workshop.shared.client.Client
import com.nerdearla.workshop.paymentMethod.BuyerPaymentMethod
import com.nerdearla.workshop.paymentMethod.error.PaymentMethodRetrievingError
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono
import java.net.URI

@Component
class PaymentMethodClient(
    webClient: WebClient
) : Client(webClient) {

    fun get(buyerId: String, token: String): BuyerPaymentMethod =
        get<BuyerPaymentMethod>(buyerId, token)
            .log { info("payment method found: {}", it) }

    override fun uri(vararg args: String): URI =
        UriComponentsBuilder
            .fromPath(path)
            .build(args)

    override fun handleError(response: ClientResponse): Mono<Throwable> =
        Mono.error<Throwable>(PaymentMethodRetrievingError())
            .log { error("Error while communicating with payment method service, {}", response) }

    companion object : CompanionLogger() {
        private const val path = "/buyers/{buyerId}/paymentMethods/token/{paymentMethodToken}"
    }
}
