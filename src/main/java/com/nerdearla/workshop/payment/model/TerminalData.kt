package com.nerdearla.workshop.payment.model

data class TerminalData(
    var establishmentId: String,
    var terminalNumber: String,
    var traceNumber: String,
    var ticketNumber: String,
    var transactionDatetime: String,
)
