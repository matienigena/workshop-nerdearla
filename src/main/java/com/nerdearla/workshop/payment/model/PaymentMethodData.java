package com.nerdearla.workshop.payment.model;

import javax.validation.constraints.Pattern;
import java.util.Objects;

public class PaymentMethodData {

    private String token;

    @Pattern(regexp = "^[0-9]*$", message = "security_code must be numeric")
    private String securityCode;

    public PaymentMethodData() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentMethodData that = (PaymentMethodData) o;
        return Objects.equals(token, that.token) && Objects.equals(securityCode, that.securityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, securityCode);
    }

    @Override
    public String toString() {
        return "PaymentMethodData{" +
                "token='" + token + '\'' +
                ", securityCode='" + securityCode + '\'' +
                '}';
    }
}
