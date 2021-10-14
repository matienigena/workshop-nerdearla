package com.nerdearla.workshop.payment

import com.nerdearla.workshop.payment.service.model.PaymentMethodData
import com.nerdearla.workshop.payment.service.model.TerminalData
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.Pattern
import javax.validation.constraints.Positive

data class PaymentRequest(

    @Pattern(regexp = "^[0-9]*\$", message = "qr_id must be numeric")
    val qrId: String,

    @Pattern(regexp = "^[0-9]*\$", message = "buyer_identification must be numeric")
    val buyerIdentification: String,

    @Pattern(regexp = "^[0-9]*\$", message = "buyer_id must be numeric")
    val buyerId: String,

    @Pattern(regexp = "^[0-9]*\$", message = "seller_id must be numeric")
    val sellerId: String,

    @Min(1, message = "amount must be at least 1")
    val amount: Double,

    @Positive(message = "installment must be positive")
    val installments: Int = 1,

    @Valid
    val terminalData: TerminalData,

    @Valid
    val paymentMethodData: PaymentMethodData
)
