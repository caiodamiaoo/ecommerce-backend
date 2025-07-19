package com.flong.ecommerce.payment;

public record PaymentRequestDTO(
        Long orderId,
        PaymentMethodEnum paymentMethod,
        String cardNumber,
        String cardExpiryDate,
        String cardCvc,
        String billingAddress,
        String shippingAddress
) {
}
