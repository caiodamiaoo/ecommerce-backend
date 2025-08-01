package com.flong.ecommerce.payment;

public enum PaymentMethodEnum {
    CREDIT_CARD("CREDIT_CARD"),
    PAYPAL("PAYPAL"),
    STRIPE("STRIPE"),
    APPLE_PAY("APPLE_PAY"),
    GOOGLE_PAY("GOOGLE_PAY"),
    PIX("PIX"),
    BOLETO("BOLETO");

    private final String method;

    PaymentMethodEnum(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
