package com.nerdearla.workshop.dto.payment

import com.nerdearla.workshop.dto.payment.PaymentMethod
import com.nerdearla.workshop.dto.payment.TerminalData

class PaymentRequest {
    var qrId: String? = null
    var buyerId: Long? = null
    var sellerId: Long? = null
    var amount: Double? = null
    var installments: Int? = null
    var paymentMethod: PaymentMethod? = null
    var terminalData: TerminalData? = null
}