package com.nerdearla.workshop.operation

import com.nerdearla.workshop.payment.model.PaymentMethodData
import com.nerdearla.workshop.paymentMethod.PaymentMethodService
import com.nerdearla.workshop.qr.QRService
import com.nerdearla.workshop.shared.IdProvider
import com.nerdearla.workshop.shared.utils.CompanionLogger
import com.nerdearla.workshop.user.buyer.BuyerService
import com.nerdearla.workshop.user.seller.SellerService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
class ExpandedOperationProvider(
    @Qualifier("paymentIdProvider")
    private val paymentIdProvider: IdProvider,
    private val paymentMethodService: PaymentMethodService,
    private val buyerService: BuyerService,
    private val sellerService: SellerService,
    private val qrService: QRService
) {

    fun provide(initialOperation: InitialOperation): ExpandedOperation =
        with(initialOperation) {
            ExpandedOperation(
                paymentId = getId(),
                qr = getQrBy(qrId),
                buyerPaymentMethod = getPaymentMethodBy(buyerId, paymentMethodData),
                seller = getSellerBy(sellerId),
                buyer = getBuyerBy(buyerId),
                terminalData = terminalData,
                amount = amount,
                installments = installments
            )
        }

    private fun getId() =
        paymentIdProvider.provide()

    private fun getQrBy(id: String) =
        qrService.getBy(id)
            .log { info("qr found: {}", it) }

    private fun getBuyerBy(id: String) =
        buyerService.getBy(id)
            .log { info("buyer found: {}", it) }

    private fun getSellerBy(id: String) =
        sellerService.getBy(id)
            .log { info("seller found: {}", it) }

    private fun getPaymentMethodBy(id: String, paymentMethodData: PaymentMethodData) =
        paymentMethodService.getBy(id, paymentMethodData)
            .log { info("payment method found: {}", it) }

    companion object : CompanionLogger()
}
