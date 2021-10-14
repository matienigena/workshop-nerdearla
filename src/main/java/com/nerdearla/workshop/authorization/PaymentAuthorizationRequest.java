package com.nerdearla.workshop.authorization;

public class PaymentAuthorizationRequest {

    private String paymentMethodToken;
    private String paymentMethodSecurityCode;
    private String holderIdentification;
    private String establishmentId;
    private String terminalNumber;
    private String traceNumber;
    private String ticketNumber;
    private String transactionDatetime;

    public String getPaymentMethodToken() {
        return paymentMethodToken;
    }

    public void setPaymentMethodToken(String paymentMethodToken) {
        this.paymentMethodToken = paymentMethodToken;
    }

    public String getPaymentMethodSecurityCode() {
        return paymentMethodSecurityCode;
    }

    public void setPaymentMethodSecurityCode(String paymentMethodSecurityCode) {
        this.paymentMethodSecurityCode = paymentMethodSecurityCode;
    }

    public String getHolderIdentification() {
        return holderIdentification;
    }

    public void setHolderIdentification(String holderIdentification) {
        this.holderIdentification = holderIdentification;
    }

    public String getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(String establishmentId) {
        this.establishmentId = establishmentId;
    }

    public String getTerminalNumber() {
        return terminalNumber;
    }

    public void setTerminalNumber(String terminalNumber) {
        this.terminalNumber = terminalNumber;
    }

    public String getTraceNumber() {
        return traceNumber;
    }

    public void setTraceNumber(String traceNumber) {
        this.traceNumber = traceNumber;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getTransactionDatetime() {
        return transactionDatetime;
    }

    public void setTransactionDatetime(String transactionDatetime) {
        this.transactionDatetime = transactionDatetime;
    }
}
