package com.flong.ecommerce.cartitem;

import java.math.BigDecimal;

public record CartItemResponseDTO(
        Long cartId,
        Long productId,
        String productName,
        BigDecimal price
) {
}
