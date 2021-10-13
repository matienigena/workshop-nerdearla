package com.nerdearla.workshop.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

public abstract class Client<T> {

    protected WebClient webClient;

    protected T get(Class<T> responseType, Object... args) {
        return webClient
                .get()
                .uri(uri(args))
                .retrieve()
                .onStatus(HttpStatus::isError, this::handleError)
                .bodyToMono(responseType)
                .block();
    }

    protected String uri(Object... args) {
        return UriComponentsBuilder.fromPath(getPath()).build(args).toString();
    }

    protected abstract Mono<Throwable> handleError(ClientResponse clientResponse);
    protected abstract String getPath();
}
