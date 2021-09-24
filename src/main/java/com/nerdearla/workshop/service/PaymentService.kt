package com.nerdearla.workshop.service

import com.nerdearla.workshop.model.*
import com.nerdearla.workshop.model.Payment.PaymentBuilder
import com.nerdearla.workshop.repository.PaymentRepository
import com.nerdearla.workshop.service.provider.FullOperationProvider
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val fullOperationProvider: FullOperationProvider,
    private val fraudService: FraudService,
    private val gatewayService: GatewayService,
    private val paymentRepository: PaymentRepository,
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

    private fun FullOperation.authorize(): AuthorizedOperation =
        gatewayService.authorize(this)

    private fun AuthorizedOperation.toPayment() =
        PaymentBuilder(first, second).build()

    private fun Payment.save() =
        paymentRepository.save(this)
}
