package com.nerdearla.workshop.payment

import com.nerdearla.workshop.authorization.GatewayService
import com.nerdearla.workshop.authorization.PaymentAuthorization
import com.nerdearla.workshop.fraud.FraudService
import com.nerdearla.workshop.fraud.FraudValidationResponse
import com.nerdearla.workshop.operation.ExpandedOperation
import com.nerdearla.workshop.operation.ExpandedOperationProvider
import com.nerdearla.workshop.operation.InitialOperation
import com.nerdearla.workshop.payment.model.Payment
import com.nerdearla.workshop.payment.repository.PaymentRepository
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val expandedOperationProvider: ExpandedOperationProvider,
    private val fraudService: FraudService,
    private val gatewayService: GatewayService,
    private val paymentRepository: PaymentRepository
) {
    //quitamos el nulo de la respuesta

    // copy vs construccion con todos los datos
    // extensions vs let / also, pros y contras
    fun processPayment(initialOperation: InitialOperation) =
        initialOperation.toExpandedOperation().let { expanded ->
            expanded.validateFraud().let { fraudValidation ->
                expanded.authorize().let { authorization ->
                    mapToPayment(expanded, authorization, fraudValidation)
                }
            }
        }.also { it.save() }


    private fun InitialOperation.toExpandedOperation() =
        expandedOperationProvider.provide(this)

    private fun ExpandedOperation.validateFraud() =
        fraudService.validateFor(buyer.identification, amount)

    private fun ExpandedOperation.authorize(): PaymentAuthorization =
        gatewayService.authorize(this)

    private fun mapToPayment(
        operation: ExpandedOperation,
        authorization: PaymentAuthorization,
        fraudValidationResponse: FraudValidationResponse
    ) =
        Payment(
            id = operation.paymentId,
            amount = operation.amount,
            authorizationId = authorization.id,
            traceNumber = authorization.traceNumber,
            buyerId = operation.buyer.id,
            sellerId = operation.seller.id,
            paymentMethodId = operation.buyerPaymentMethod.id,
            qrId = operation.qr.id,
            fraudValidationId = fraudValidationResponse.fraudValidationId
        )

    private fun Payment.save() =
        paymentRepository.save(this)
}
