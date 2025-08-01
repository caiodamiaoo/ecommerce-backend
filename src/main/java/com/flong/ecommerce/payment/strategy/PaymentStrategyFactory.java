package com.flong.ecommerce.payment.strategy;

import com.flong.ecommerce.payment.PaymentMethodEnum;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PaymentStrategyFactory {

    private final Map<PaymentMethodEnum, PaymentStrategy> strategies;

    public PaymentStrategyFactory(List<PaymentStrategy> strategyList) {
        strategies = strategyList.stream()
                .collect(Collectors.toMap(PaymentStrategy::getPaymentMethod, Function.identity()));
    }

    public PaymentStrategy getStrategy(PaymentMethodEnum paymentMethod) {
        return strategies.get(paymentMethod);
    }
}
