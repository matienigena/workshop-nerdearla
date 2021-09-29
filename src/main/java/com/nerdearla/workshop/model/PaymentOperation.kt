package com.nerdearla.workshop.model

import com.nerdearla.workshop.dto.buyer.Buyer
import com.nerdearla.workshop.dto.buyer.paymentMethod.BuyerPaymentMethod
import com.nerdearla.workshop.dto.fraud.FraudValidationResponse
import com.nerdearla.workshop.dto.payment.PaymentMethodData
import com.nerdearla.workshop.dto.payment.PaymentRequest
import com.nerdearla.workshop.dto.payment.TerminalData
import com.nerdearla.workshop.dto.qr.QR
import com.nerdearla.workshop.dto.seller.Seller

data class InitialOperation(
    val qrId: String,
    val buyerId: String,
    val identification: String,
    val gender: String,
    val sellerId: String,
    val amount: Double,
    val installments: Int = 1,
    val terminalData: TerminalData,
    val paymentMethodData: PaymentMethodData
)

data class FullOperation(
    val paymentId: String,
    val qr: QR,
    val buyerPaymentMethod: BuyerPaymentMethod,
    val amount: Double,
    val installments: Int = 1,
    val seller: Seller,
    val buyer: Buyer,
    val terminalData: TerminalData
)

data class NotFraudulentOperation(
    val paymentId: String,
    val qr: QR,
    val buyerPaymentMethod: BuyerPaymentMethod,
    val amount: Double,
    val installments: Int = 1,
    val seller: Seller,
    val buyer: Buyer,
    val terminalData: TerminalData,
    val fraudResponse: FraudValidationResponse
)

data class AuthorizedOperation(
    val paymentId: String,
    val qr: QR,
    val buyerPaymentMethod: BuyerPaymentMethod,
    val amount: Double,
    val installments: Int = 1,
    val seller: Seller,
    val buyer: Buyer,
    val terminalData: TerminalData,
    val fraudResponse: FraudValidationResponse,
    val authorization: PaymentAuthorization
)
