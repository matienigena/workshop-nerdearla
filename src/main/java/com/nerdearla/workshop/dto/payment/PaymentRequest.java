package com.nerdearla.workshop.dto.payment;

public class PaymentRequest {

    private String qrId;

    private Long buyerId;

    private Long sellerId;

    private Double amount;

    private Integer installments;

    private PaymentMethod paymentMethod;

    private TerminalData terminalData;

    public String getQrId() {
        return qrId;
    }

    public void setQrId(String qrId) {
        this.qrId = qrId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
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

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public TerminalData getTerminalData() {
        return terminalData;
    }

    public void setTerminalData(TerminalData terminalData) {
        this.terminalData = terminalData;
    }
}
