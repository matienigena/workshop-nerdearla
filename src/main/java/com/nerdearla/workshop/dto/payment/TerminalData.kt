package com.nerdearla.workshop.dto.payment

data class TerminalData(
    var establishmentId: String,
    var terminalNumber: String,
    var traceNumber: String,
    var ticketNumber: String,
    var transactionDatetime: String,
)
