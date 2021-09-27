package com.nerdearla.workshop.service.provider

import com.nerdearla.workshop.model.FullOperation
import com.nerdearla.workshop.service.GatewayService
import org.springframework.stereotype.Component

@Component
class AuthorizedOperationProvider(
    private val gatewayService: GatewayService
) {

    fun provide(fullOperation: FullOperation): FullOperation =
        fullOperation.copy(
            authorization = gatewayService.authorize(fullOperation)
        )
}