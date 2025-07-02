package com.flong.ecommerce.product;

import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static final String PRICE = "price";

    private ProductSpecification() {
    }

    public static Specification<Product> findByPriceRange(ProductRequestDTO dto) {
        return (root, query, criteriaBuilder) -> {
            if (dto.minPrice() != null && dto.maxPrice() != null) {
                return criteriaBuilder.between(root.get(PRICE), dto.minPrice(), dto.maxPrice());
            } else if (dto.minPrice() != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get(PRICE), dto.minPrice());
            } else if (dto.maxPrice() != null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get(PRICE), dto.maxPrice());
            }
            return criteriaBuilder.conjunction();
        };
    }
}
