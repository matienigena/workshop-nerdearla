package com.nerdearla.workshop.payment.model;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.Objects;

public class PaymentRequest {

    @Pattern(regexp = "^[0-9]*$", message = "qr_id must be numeric")
    private String qrId;

    @Pattern(regexp = "^[0-9]*$", message = "buyer_id must be numeric")
    private String buyerId;

    @Pattern(regexp = "^[0-9]*$", message = "seller_id must be numeric")
    private String sellerId;

    @Min(value = 1, message = "amount must be at least 1")
    private Double amount;

    @Positive(message = "installment must be positive")
    private Integer installments;

    @Valid
    private TerminalData terminalData;

    @Valid
    private PaymentMethodData paymentMethodData;

    public PaymentRequest() {
    }

    public String getQrId() {
        return qrId;
    }

    public void setQrId(String qrId) {
        this.qrId = qrId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public TerminalData getTerminalData() {
        return terminalData;
    }

    public void setTerminalData(TerminalData terminalData) {
        this.terminalData = terminalData;
    }

    public PaymentMethodData getPaymentMethodData() {
        return paymentMethodData;
    }

    public void setPaymentMethodData(PaymentMethodData paymentMethodData) {
        this.paymentMethodData = paymentMethodData;
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
                ", paymentMethod=" + paymentMethodData +
                '}';
    }
}
