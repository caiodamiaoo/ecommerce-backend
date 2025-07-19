package com.flong.ecommerce.payment;

import com.flong.ecommerce.payment.strategy.PaymentStrategy;
import com.flong.ecommerce.payment.strategy.PaymentStrategyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentStrategyFactory paymentStrategyFactory;

    public PaymentResponseDTO processPayment(PaymentRequestDTO paymentRequestDTO) {
        PaymentStrategy paymentStrategy = paymentStrategyFactory.getStrategy(paymentRequestDTO.paymentMethod());
        return paymentStrategy.processPayment(paymentRequestDTO);
    }
}
