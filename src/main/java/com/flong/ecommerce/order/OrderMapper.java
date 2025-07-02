package com.flong.ecommerce.order;

import com.flong.ecommerce.orderitem.OrderItemMapper;
import com.flong.ecommerce.shipping.Shipping;
import com.flong.ecommerce.util.UtilDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final OrderItemMapper orderItemMapper;

    public OrderResponseDTO toResponseDTO(Order order) {
        return Optional.ofNullable(order)
                .map(o -> new OrderResponseDTO(
                        o.getUser().getName(),
                        o.getId(),
                        o.getStatus(),
                        o.getShippingAddress().getLine1(),
                        o.getBillingAddress().getLine1(),
                        UtilDate.formatDate(o.getCreatedAt()),
                        UtilDate.formatDate(o.getUpdatedAt()),
                        o.getTotalAmount(),
                        o.getShipping()
                                .stream()
                                .filter(s -> s.getStatus().equals("ENVIADO"))
                                .map(Shipping::getCost)
                                .findFirst()
                                .orElse(null),
                        null,
                        null,
                        o.getOrderItem()
                                .stream()
                                .map(orderItemMapper::toResponseDTO)
                                .toList()
                ))
                .orElse(null);
    }
}
