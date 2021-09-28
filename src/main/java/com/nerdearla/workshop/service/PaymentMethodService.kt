package com.nerdearla.workshop.service

import com.nerdearla.workshop.dto.payment.PaymentMethodData
import com.nerdearla.workshop.dto.buyer.paymentMethod.BuyerPaymentMethod
import com.nerdearla.workshop.validator.PaymentMethodValidator
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class PaymentMethodService(
    private val validator: PaymentMethodValidator,
    private val webClient: WebClient
) {
    fun findByBuyerIdAndPaymentMethodToken(buyerId: String, paymentMethodData: PaymentMethodData) =
        webClient
            .getBuyerPaymentMethod(buyerId, paymentMethodData.token)
        .also {
        validator.validate(
            buyerPaymentMethod = it,
            paymentMethodData = paymentMethodData
        )
    }

    private fun WebClient.getBuyerPaymentMethod(buyerId: String, token: String) =
        get()
            .uri { uriBuilder ->
                uriBuilder
                    .path("/buyers/{buyerId}/paymentMethods/token/{paymentMethodToken}")
                    .build(buyerId, token)
            }
            .retrieve().bodyToMono(BuyerPaymentMethod::class.java).block()!!
}


