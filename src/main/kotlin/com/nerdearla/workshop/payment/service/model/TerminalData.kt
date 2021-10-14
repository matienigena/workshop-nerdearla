package com.nerdearla.workshop.payment.service.model

import javax.validation.constraints.Pattern

data class TerminalData(

    @Pattern(regexp = "^[0-9]*\$", message = "establishment_id must be numeric")
    val establishmentId: String,

    @Pattern(regexp = "^[0-9]*\$", message = "terminal_number must be numeric")
    val terminalNumber: String,

    @Pattern(regexp = "^[0-9]*\$", message = "trace_number must be numeric")
    val traceNumber: String,

    @Pattern(regexp = "^[0-9]*\$", message = "ticket_number must be numeric")
    val ticketNumber: String,

    val transactionDatetime: String,
)
