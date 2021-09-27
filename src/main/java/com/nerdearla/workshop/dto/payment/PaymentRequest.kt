package com.nerdearla.workshop.dto.payment

//Cambiamos a dataclass
//quitamos los nulos
//cambiamos a vals

data class PaymentRequest(
    val qrId: String,
    val buyerId: String,
    val sellerId: String,
    val amount: Double,
    val installments: Int = 1,
    val identification: String,
    val terminalData: TerminalData,
    val paymentMethodData: PaymentMethodData
)
