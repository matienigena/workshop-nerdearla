package com.nerdearla.workshop.fraud.error

import org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import org.springframework.web.server.ResponseStatusException

class OperationNotAllowedError :
    ResponseStatusException(UNPROCESSABLE_ENTITY, "operation not allowed")
