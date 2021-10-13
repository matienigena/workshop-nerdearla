package com.nerdearla.workshop.shared.client;

import org.springframework.http.HttpStatus;

// Ver de rearmarlo sin Get / Post
public abstract class GetClient<T> extends BaseClient {

    protected T get(Class<T> responseType, Object... args) {
        return webClient
                .get()
                .uri(uri(args))
                .retrieve()
                .onStatus(HttpStatus::isError, this::handleError)
                .bodyToMono(responseType)
                .block();
    }

}
