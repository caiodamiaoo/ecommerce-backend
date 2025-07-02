package com.flong.ecommerce.order;

import com.flong.ecommerce.orderitem.OrderItemResponseDTO;

import java.math.BigDecimal;
import java.util.List;

public record OrderResponseDTO(
        String userName,
        Long orderNumber,
        String status,
        String shippingAddress,
        String billingAddress,
        String createdAt,
        String updatedAt,
        BigDecimal totalAmount,
        BigDecimal shippingCost,
        BigDecimal discountAmount,
        Integer taxAmount,
        List<OrderItemResponseDTO> orderItems
) {
}
