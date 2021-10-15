package com.nerdearla.workshop.payment;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nerdearla.workshop.payment.service.model.PaymentMethodData;
import com.nerdearla.workshop.payment.service.model.TerminalData;

import java.util.Objects;

public class PaymentRequest {

    private final String qrId;
    private final String buyerId;
    private final String sellerId;
    private final Double amount;
    private final Integer installments;
    private final TerminalData terminalData;
    private final PaymentMethodData paymentMethodData;

    @JsonCreator
    public PaymentRequest(
            @JsonProperty("qrId") String qrId,
            @JsonProperty("buyerId") String buyerId,
            @JsonProperty("sellerId") String sellerId,
            @JsonProperty("amount") Double amount,
            @JsonProperty("installments") Integer installments,
            @JsonProperty("terminalData") TerminalData terminalData,
            @JsonProperty("paymentMethodData") PaymentMethodData paymentMethodData) {
        this.qrId = qrId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.amount = amount;
        this.installments = installments;
        this.terminalData = terminalData;
        this.paymentMethodData = paymentMethodData;
    }

    public String getQrId() {
        return qrId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public Double getAmount() {
        return amount;
    }

    public Integer getInstallments() {
        return installments;
    }

    public TerminalData getTerminalData() {
        return terminalData;
    }

    public PaymentMethodData getPaymentMethodData() {
        return paymentMethodData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentRequest that = (PaymentRequest) o;
        return Objects.equals(qrId, that.qrId) && Objects.equals(buyerId, that.buyerId) && Objects.equals(sellerId, that.sellerId) && Objects.equals(amount, that.amount) && Objects.equals(installments, that.installments) && Objects.equals(terminalData, that.terminalData) && Objects.equals(paymentMethodData, that.paymentMethodData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qrId, buyerId, sellerId, amount, installments, terminalData, paymentMethodData);
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "qrId='" + qrId + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", sellerId='" + sellerId + '\'' +
                ", amount=" + amount +
                ", installments=" + installments +
                ", terminalData=" + terminalData +
                ", paymentMethodData=" + paymentMethodData +
                '}';
    }
}
