package com.flong.ecommerce.orderitem;

import java.math.BigDecimal;

public record OrderItemResponseDTO(
        String productName,
        BigDecimal productPrice,
        Integer quantity,
        String note
) {
}
