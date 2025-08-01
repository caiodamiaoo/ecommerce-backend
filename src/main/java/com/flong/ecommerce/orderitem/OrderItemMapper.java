package com.flong.ecommerce.orderitem;

import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    public OrderItemResponseDTO toResponseDTO(OrderItem orderItem) {
        if (orderItem == null) {
            return null;
        }

        return new OrderItemResponseDTO(
                orderItem.getProduct().getName(),
                orderItem.getProduct().getPrice(),
                orderItem.getQuantity(),
                null
        );
    }
}
