package com.nerdearla.workshop.service.provider

import com.nerdearla.workshop.dto.payment.PaymentMethodData
import com.nerdearla.workshop.model.FullOperation
import com.nerdearla.workshop.model.InitialOperation
import com.nerdearla.workshop.service.*
import org.springframework.stereotype.Component

@Component
class FullOperationProvider(
    private val paymentIdProvider: PaymentIdProvider,
    private val paymentMethodService: PaymentMethodService,
    private val buyerService: BuyerService,
    private val sellerService: SellerService,
    private val qrService: QRService
) {

    fun provide(initialOperation: InitialOperation) =
        with(initialOperation) {
            FullOperation(
                paymentId = paymentIdProvider.next,
                qr = provideQrBy(qrId),
                paymentMethod = providePaymentMethodBy(paymentMethodData),
                seller = provideSellerBy(sellerId),
                buyer = provideBuyerBy(buyerId),
                terminalData = terminalData,
                amount = amount,
                installments = installments
            )
        }

    // Hablar de no usar extensiones
    // meter logging / also
    private fun provideQrBy(qrId: String) =
        qrService.findValidQR(qrId)

    private fun provideBuyerBy(buyerId: String) =
        buyerService.findBuyer(buyerId)

    private fun provideSellerBy(sellerId: String) =
        sellerService.findSeller(sellerId)

    private fun providePaymentMethodBy(paymentMethodData: PaymentMethodData) =
        paymentMethodService.authorize(paymentMethodData)
}
