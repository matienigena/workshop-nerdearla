package com.nerdearla.workshop.shared.advice;

import com.nerdearla.workshop.shared.error.APIError;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public APIError handleException(Exception e) {
        return new APIError(e.getMessage());
    }
}
