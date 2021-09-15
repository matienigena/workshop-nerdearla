package com.nerdearla.workshop.model

import com.nerdearla.workshop.dto.payment.PaymentRequest

class PaymentOperation {
    private val paymentId: String? = null
    private val qrId: String? = null
    private val buyer: Buyer? = null
    private val seller: Seller? = null

    inner class Builder {
        private val buyerId: Long? = null
        fun fromPaymentRequest(paymentRequest: PaymentRequest?): Builder {}
        fun build(): PaymentOperation {
            return PaymentOperation()
        }
    }
}