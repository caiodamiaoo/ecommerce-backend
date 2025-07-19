package com.flong.ecommerce.payment.strategy;

import com.flong.ecommerce.payment.PaymentMethodEnum;
import com.flong.ecommerce.payment.PaymentRequestDTO;
import com.flong.ecommerce.payment.PaymentResponseDTO;

public interface PaymentStrategy {
    PaymentResponseDTO processPayment(PaymentRequestDTO paymentRequestDTO);

    PaymentMethodEnum getPaymentMethod();
}
