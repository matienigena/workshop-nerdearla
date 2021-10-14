package com.nerdearla.workshop.payment

import com.nerdearla.workshop.authorization.GatewayService
import com.nerdearla.workshop.operation.AuthorizedOperation
import com.nerdearla.workshop.operation.ExpandedOperation
import com.nerdearla.workshop.operation.ExpandedOperationProvider
import com.nerdearla.workshop.operation.InitialOperation
import com.nerdearla.workshop.payment.model.Payment
import com.nerdearla.workshop.payment.repository.PaymentRepository
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val expandedOperationProvider: ExpandedOperationProvider,
    private val gatewayService: GatewayService,
    private val paymentRepository: PaymentRepository
) {
    //quitamos el nulo de la respuesta

    // copy vs construccion con todos los datos
    // extensions vs let / also, pros y contras
    fun processPayment(initialOperation: InitialOperation) =
        initialOperation
            .expandEntities()
            .authorize()
            .toPayment()
            .also { save(it) }

    private fun InitialOperation.expandEntities() =
        expandedOperationProvider.provide(this)
            .log { info("operation expanded {}", it) }

    private fun ExpandedOperation.authorize() =
        gatewayService.authorize(this)
            .log { info("authorization response: {}", it) }
            .let { AuthorizedOperation(this, it.id) }

    private fun AuthorizedOperation.toPayment() =
        Payment(
            id = operation.paymentId,
            amount = operation.amount,
            authorizationId = authorizationId,
            buyerId = operation.buyer.id,
            sellerId = operation.seller.id,
            paymentMethodId = operation.buyerPaymentMethod.id,
            qrId = operation.qr.id,
        )

    private fun save(payment: Payment) =
        paymentRepository.save(payment)
            .log { info("payment {} saved", payment.id) }

    companion object : CompanionLogger()
}
