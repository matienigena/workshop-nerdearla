package com.nerdearla.workshop.qr.client

import com.nerdearla.workshop.qr.QR
import com.nerdearla.workshop.qr.error.QrRetrievingError
import com.nerdearla.workshop.shared.client.Client
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class QrClient(
    webClient: WebClient
) : Client(webClient) {

    override val path = "/qrs/{qrId}"

    fun getBy(id: String): QR =
        get(QR::class.java, id)
            .log { info("qr found: {}", it) }

    override fun handleError(response: ClientResponse): Mono<Throwable> =
        Mono.error<Throwable>(QrRetrievingError())
            .log { error("Error while communicating with qr service, {}", response) }

    companion object : CompanionLogger()
}
