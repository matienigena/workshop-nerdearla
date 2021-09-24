package com.nerdearla.workshop.service.provider

import com.nerdearla.workshop.dto.payment.PaymentMethod
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
                paymentMethod = providePaymentMethodBy(paymentMethod),
                seller = provideSellerBy(sellerId),
                buyer = provideBuyerBy(buyerId),
                terminalData = terminalData
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

    private fun providePaymentMethodBy(paymentMethod: PaymentMethod) =
        paymentMethodService.authorize(paymentMethod)
}
