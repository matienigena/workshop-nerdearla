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
                buyerPaymentMethod = providePaymentMethodBy(buyerId, paymentMethodData),
                seller = provideSellerBy(sellerId),
                buyer = provideBuyerBy(buyerId, identification, gender),
                terminalData = terminalData,
                amount = amount,
                installments = installments
            )
        }

    // Hablar de no usar extensiones
    // meter logging / also
    private fun provideQrBy(qrId: String) =
        qrService.findValidQR(qrId)

    private fun provideBuyerBy(buyerId: String, identification: String, gender: String) =
        buyerService.findBuyer(buyerId, identification, gender)

    private fun provideSellerBy(sellerId: String) =
        sellerService.findSeller(sellerId)

    private fun providePaymentMethodBy(buyerId: String, paymentMethodData: PaymentMethodData) =
        paymentMethodService.findByBuyerIdAndPaymentMethodToken(buyerId, paymentMethodData)
}
