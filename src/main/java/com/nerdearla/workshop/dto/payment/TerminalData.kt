package com.nerdearla.workshop.dto.payment

import com.nerdearla.workshop.dto.payment.PaymentMethod
import com.nerdearla.workshop.dto.payment.TerminalData

class TerminalData {
    var establishmentId: String? = null
    var terminalNumber: String? = null
    var traceNumber: String? = null
    var ticketNumber: String? = null

    // TODO: Date with format
    var transactionDatetime: String? = null
}