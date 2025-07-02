package com.flong.ecommerce.product;

import java.math.BigDecimal;

public record ProductRequestDTO(
        Long id,
        String sku,
        String name,
        String description,
        BigDecimal price,
        BigDecimal weight,
        BigDecimal height,
        BigDecimal width,
        BigDecimal depth,
        BigDecimal minPrice,
        BigDecimal maxPrice) {
}
