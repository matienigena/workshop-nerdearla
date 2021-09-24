package com.nerdearla.workshop.model

import com.nerdearla.workshop.dto.payment.PaymentRequest
import com.nerdearla.workshop.dto.payment.TerminalData

data class PaymentOperation(
    val paymentRequest: PaymentRequest,
    val paymentId: String? = null,
    val qr: QR? = null,
    val buyer: Buyer? = null,
    val seller: Seller? = null,
    val paymentMethod: PaymentMethod? = null,
)

data class InitialOperation(
    val qrId: String,
    val buyerId: String,
    val sellerId: String,
    val amount: Double,
    val installments: Int = 1,
    val terminalData: TerminalData,
    val paymentMethod: com.nerdearla.workshop.dto.payment.PaymentMethod
)

data class FullOperation(
    val paymentId: String,
    val qr: QR,
    val paymentMethod: PaymentMethod,
    val seller: Seller,
    val buyer: Buyer,
    val terminalData: TerminalData
)

data class AuthorizedOperation(
    val authorizationId: String,
    val paymentId: String,
    val qr: QR,
    val paymentMethod: PaymentMethod,
    val seller: Seller,
    val buyer: Buyer,
    val terminalData: TerminalData
)
