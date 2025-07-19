package com.flong.ecommerce.cart;

public record CartRequestDTO(
        Long productId,
        Long quantity,
        Long attributeId,
        Long couponId,
        String note,
        String imageUrl,
        String productName,
        String attributeName,
        String couponName,
        String couponCode
) {
}
