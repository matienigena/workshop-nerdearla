package com.nerdearla.workshop.payment.model;

import javax.validation.constraints.Pattern;
import java.util.Objects;

public class TerminalData {

    @Pattern(regexp = "^[0-9]*$", message = "establishment_id must be numeric")
    private String establishmentId;

    @Pattern(regexp = "^[0-9]*$", message = "terminal_number must be numeric")
    private String terminalNumber;

    @Pattern(regexp = "^[0-9]*$", message = "trace_number must be numeric")
    private String traceNumber;

    @Pattern(regexp = "^[0-9]*$", message = "ticket_number must be numeric")
    private String ticketNumber;

    private String transactionDatetime;

    public TerminalData() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TerminalData that = (TerminalData) o;
        return Objects.equals(establishmentId, that.establishmentId) && Objects.equals(terminalNumber, that.terminalNumber) && Objects.equals(traceNumber, that.traceNumber) && Objects.equals(ticketNumber, that.ticketNumber) && Objects.equals(transactionDatetime, that.transactionDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(establishmentId, terminalNumber, traceNumber, ticketNumber, transactionDatetime);
    }

    @Override
    public String toString() {
        return "TerminalData{" +
                "establishmentId='" + establishmentId + '\'' +
                ", terminalNumber='" + terminalNumber + '\'' +
                ", traceNumber='" + traceNumber + '\'' +
                ", ticketNumber='" + ticketNumber + '\'' +
                ", transactionDatetime='" + transactionDatetime + '\'' +
                '}';
    }
}
