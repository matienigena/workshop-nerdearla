package com.nerdearla.workshop.client;

import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

public abstract class BaseClient {

    protected WebClient webClient;

    protected String uri(Object... args) {
        return UriComponentsBuilder.fromPath(getPath()).build(args).toString();
    }

    protected abstract Mono<Throwable> handleError(ClientResponse clientResponse);
    protected abstract String getPath();
}
