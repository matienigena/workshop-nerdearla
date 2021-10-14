package com.nerdearla.workshop.paymentMethod;

public class BuyerPaymentMethod {

    private String id;
    private String enabled;
    private String type;
    private String token;
    private String securityCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
