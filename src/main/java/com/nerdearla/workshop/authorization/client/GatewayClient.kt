package com.nerdearla.workshop.authorization.client

import com.nerdearla.workshop.authorization.PaymentAuthorizationRequest
import com.nerdearla.workshop.authorization.PaymentAuthorizationResponse
import com.nerdearla.workshop.authorization.error.AuthorizationError
import com.nerdearla.workshop.shared.client.Client
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class GatewayClient(
    webClient: WebClient
) : Client(webClient) {

    override val path: String = "/authorizations"

    fun authorize(request: PaymentAuthorizationRequest) =
        post(
            PaymentAuthorizationResponse::class.java,
            PaymentAuthorizationRequest::class.java,
            request
        )
            .log { info("authorization done: {}", it) }

    override fun handleError(response: ClientResponse): Mono<Throwable> =
        Mono.error<Throwable>(AuthorizationError())
            .log { error("Error while communicating with authorization service, {}", response) }

    companion object : CompanionLogger()
}
