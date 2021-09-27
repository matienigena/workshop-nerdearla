package com.nerdearla.workshop.model

import com.nerdearla.workshop.dto.payment.PaymentMethodData
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
    val paymentMethodData: PaymentMethodData
)

data class FullOperation(
    val paymentId: String,
    val qr: QR,
    val paymentMethod: PaymentMethod,
    val amount: Double,
    val installments: Int = 1,
    val seller: Seller,
    val buyer: Buyer,
    val terminalData: TerminalData
)

data class AuthorizedOperation(
    val paymentId: String,
    val qr: QR,
    val paymentMethod: PaymentMethod,
    val amount: Double,
    val installments: Int = 1,
    val seller: Seller,
    val buyer: Buyer,
    val terminalData: TerminalData,
    val authorization: PaymentAuthorization
)
