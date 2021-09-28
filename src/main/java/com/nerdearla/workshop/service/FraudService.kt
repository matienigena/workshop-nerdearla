package com.nerdearla.workshop.service

import com.nerdearla.workshop.dto.fraud.FraudValidationRequest
import com.nerdearla.workshop.dto.fraud.FraudValidationResponse
import com.nerdearla.workshop.validator.FraudValidator
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class FraudService(
    private val validator: FraudValidator,
    private val webClient: WebClient
) {
    fun validate(fraudValidationRequest: FraudValidationRequest) =
        fraudValidationRequest
            .validateFraud()
            .also {
                validator.validate(it)
            }

    private fun FraudValidationRequest.validateFraud() =
        webClient
            .post()
            .uri("/fraud")
            .body(Mono.just(this), this.javaClass)
            .retrieve()
            .bodyToMono(FraudValidationResponse::class.java)
            .block()!!

}


