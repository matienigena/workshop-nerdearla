package com.nerdearla.workshop.shared.client

import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono
import java.net.URI

abstract class Client(
    protected val webClient: WebClient
) {

    protected abstract val path: String

    protected inline fun <reified T : Any> get(vararg uriArgs: String): T =
        webClient
            .get()
            .uri(uri(*uriArgs))
            .retrieve()
            .onStatus(HttpStatus::isError) { response -> handleError(response) }
            .bodyToMono<T>()
            .block()!!

    protected inline fun <reified T : Any, reified R : Any> post(request: R, vararg uriArgs: String): T =
        webClient
            .post()
            .uri(uri(*uriArgs))
            .body(Mono.just(request), R::class.java)
            .retrieve()
            .onStatus(HttpStatus::isError) { response -> handleError(response) }
            .bodyToMono<T>()
            .block()!!

    protected fun uri(vararg args: String): URI =
        UriComponentsBuilder
            .fromPath(path)
            .build(args)

    protected abstract fun handleError(response: ClientResponse): Mono<Throwable>

}
