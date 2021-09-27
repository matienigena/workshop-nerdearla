package com.nerdearla.workshop.service

import com.nerdearla.workshop.model.*
import com.nerdearla.workshop.repository.PaymentRepository
import com.nerdearla.workshop.service.provider.AuthorizedOperationProvider
import com.nerdearla.workshop.service.provider.FullOperationProvider
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val fullOperationProvider: FullOperationProvider,
    private val fraudService: FraudService,
    private val paymentRepository: PaymentRepository,
    private val authorizedOperationProvider: AuthorizedOperationProvider
) {
    //quitamos el nulo de la respuesta

    fun processPayment(initialOperation: InitialOperation): Payment =
    // copy vs construccion con todos los datos
        // extensions vs let / also, pros y contras
        initialOperation
            .toFullOperation()
            .also { it.validateFraud() }
            .authorize()
            .toPayment()
            .also { it.save() }


    private fun InitialOperation.toFullOperation() =
        fullOperationProvider.provide(this)

    private fun FullOperation.validateFraud() =
        fraudService.authorize(this)

    private fun FullOperation.authorize(): FullOperation =
        authorizedOperationProvider.provide(this)


    private fun FullOperation.toPayment() =
        Payment(
            paymentId = paymentId,
            amount = amount,
            authorizationId = authorization!!.id,
            traceNumber = authorization.traceNumber,
            buyerId = buyer.buyerId,
            sellerId = seller.sellerId,
            paymentMethodId = paymentMethod.paymentMethodId,
            qrId = qr.qrId
        )

    private fun Payment.save() =
        paymentRepository.save(this)
}
