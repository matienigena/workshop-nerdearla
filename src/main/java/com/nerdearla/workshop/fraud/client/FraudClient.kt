package com.nerdearla.workshop.fraud.client

import com.nerdearla.workshop.shared.client.Client
import com.nerdearla.workshop.fraud.FraudValidationRequest
import com.nerdearla.workshop.fraud.FraudValidationResponse
import com.nerdearla.workshop.fraud.error.FraudValidationError
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class FraudClient(
    webClient: WebClient
) : Client(webClient) {

    override val path = "/fraud"

    fun validate(request: FraudValidationRequest) =
        post<FraudValidationResponse, FraudValidationRequest>(request)
            .log { info("fraud validation done: {}", it) }

    override fun handleError(response: ClientResponse): Mono<Throwable> =
        Mono.error<Throwable>(FraudValidationError())
            .log { error("Error while communicating with fraud service, {}", response) }

    companion object : CompanionLogger()
}
