package com.nerdearla.workshop.service

import com.nerdearla.workshop.model.*
import com.nerdearla.workshop.repository.PaymentRepository
import com.nerdearla.workshop.service.provider.AuthorizedOperationProvider
import com.nerdearla.workshop.service.provider.FullOperationProvider
import com.nerdearla.workshop.service.provider.NotFraudulentOperationProvider
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val fullOperationProvider: FullOperationProvider,
    private val notFraudulentOperationProvider: NotFraudulentOperationProvider,
    private val paymentRepository: PaymentRepository,
    private val authorizedOperationProvider: AuthorizedOperationProvider
) {
    //quitamos el nulo de la respuesta

    fun processPayment(initialOperation: InitialOperation) =
    // copy vs construccion con todos los datos
        // extensions vs let / also, pros y contras
        initialOperation
            .toFullOperation()
            .toNotFraudulentOperation()
            .authorize()
            .toPayment()
            .also { it.save() }


    private fun InitialOperation.toFullOperation() =
        fullOperationProvider.provide(this)

    private fun FullOperation.toNotFraudulentOperation(): NotFraudulentOperation =
        notFraudulentOperationProvider.provide(this)


    private fun NotFraudulentOperation.authorize(): AuthorizedOperation =
        authorizedOperationProvider.provide(this)


    private fun AuthorizedOperation.toPayment() =
        Payment(
            id = paymentId,
            amount = amount,
            authorizationId = authorization.id,
            traceNumber = authorization.traceNumber,
            buyerId = buyer.id,
            sellerId = seller.id,
            paymentMethodId = buyerPaymentMethod.id,
            qrId = qr.id,
            fraudValidationId = fraudResponse.fraudValidationId
        )

    private fun Payment.save() =
        paymentRepository.save(this)
}
