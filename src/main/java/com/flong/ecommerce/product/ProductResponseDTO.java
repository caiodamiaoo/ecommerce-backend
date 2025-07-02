package com.flong.ecommerce.product;

import java.math.BigDecimal;

public record ProductResponseDTO(
        Long id,
        String sku,
        String name,
        String description,
        BigDecimal price,
        BigDecimal weight,
        BigDecimal height,
        BigDecimal width,
        BigDecimal depth
) {
}
