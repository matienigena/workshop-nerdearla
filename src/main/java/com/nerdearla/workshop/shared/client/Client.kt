package com.nerdearla.workshop.shared.client

import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono
import java.net.URI

abstract class Client(
    private val webClient: WebClient
) {

    protected abstract val path: String

    protected fun <T> get(responseType: Class<T>, vararg uriArgs: String): T =
        webClient
            .get()
            .uri(uri(*uriArgs))
            .retrieve()
            .onStatus(HttpStatus::isError) { response -> handleError(response) }
            .bodyToMono(responseType)
            .block()!!

    protected fun <T, R> post(
        responseType: Class<T>,
        requestType: Class<R>,
        request: R,
        vararg uriArgs: String
    ): T =
        webClient
            .post()
            .uri(uri(*uriArgs))
            .body(Mono.just(request), requestType)
            .retrieve()
            .onStatus(HttpStatus::isError) { response -> handleError(response) }
            .bodyToMono(responseType)
            .block()!!

    private fun uri(vararg args: String) =
        UriComponentsBuilder
            .fromPath(path)
            .build(*args)
            .toString()

    protected abstract fun handleError(response: ClientResponse): Mono<Throwable>

}
