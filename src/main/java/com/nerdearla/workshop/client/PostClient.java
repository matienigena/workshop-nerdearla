package com.nerdearla.workshop.client;

import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

public abstract class PostClient<T, R> extends BaseClient {

    protected T post(Class<T> responseType, Class<R> requestType, R request, Object... args) {
        return webClient
                .post()
                .uri(uri(args))
                .body(Mono.just(request), requestType)
                .retrieve()
                .onStatus(HttpStatus::isError, this::handleError)
                .bodyToMono(responseType)
                .block();
    }
}
