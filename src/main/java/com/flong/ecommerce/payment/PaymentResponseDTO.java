package com.flong.ecommerce.payment;

public record PaymentResponseDTO(
        Long amount,
        String status,
        String paymentMethod
) {
}
