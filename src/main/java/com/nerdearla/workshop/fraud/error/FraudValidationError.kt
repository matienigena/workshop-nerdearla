package com.nerdearla.workshop.fraud.error

import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.web.server.ResponseStatusException

class FraudValidationError :
    ResponseStatusException(INTERNAL_SERVER_ERROR, "error while validating fraud")
