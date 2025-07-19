package com.flong.ecommerce.payment.strategy;

import com.flong.ecommerce.payment.PaymentMethodEnum;
import com.flong.ecommerce.payment.PaymentRequestDTO;
import com.flong.ecommerce.payment.PaymentResponseDTO;
import com.flong.ecommerce.payment.client.OrderClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PixPaymentStrategy implements PaymentStrategy {

    private final OrderClientService orderClientService;

    @Override
    public PaymentResponseDTO processPayment(PaymentRequestDTO paymentRequestDTO) {
        return orderClientService.createOrderPix(paymentRequestDTO);
    }

    @Override
    public PaymentMethodEnum getPaymentMethod() {
        return PaymentMethodEnum.PIX;
    }
}
