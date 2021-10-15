package com.nerdearla.workshop.qr.client;

import com.nerdearla.workshop.qr.QR;
import com.nerdearla.workshop.qr.error.QRRetrievingError;
import com.nerdearla.workshop.shared.client.GetClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class QRClient extends GetClient<QR> {

    private static final Logger LOGGER = LoggerFactory.getLogger(QRClient.class);

    public QRClient(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    protected Mono<Throwable> handleError(ClientResponse clientResponse) {
        LOGGER.error("Error while communicating with QR service, {}", clientResponse);
        return Mono.error(new QRRetrievingError());
    }

    @Override
    protected String getPath() {
        return "/qrs/{qrId}";
    }

    public QR getById(String id) {
        QR qr = get(QR.class, id);
        LOGGER.info("qr found: {}", qr);
        return qr;
    }
}
