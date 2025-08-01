package com.flong.ecommerce.product;


import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponseDTO toDto(Product product) {
        if (product == null) {
            return null;
        }

        return new ProductResponseDTO(
                product.getId(),
                product.getSku(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getWeight(),
                product.getHeight(),
                product.getWidth(),
                product.getDepth()
        );
    }

    public Product toEntity(ProductRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Product product = new Product();
        product.setId(dto.id());
        product.setSku(dto.sku());
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setWeight(dto.weight());
        product.setHeight(dto.height());
        product.setWidth(dto.width());
        product.setDepth(dto.depth());

        return product;
    }
}
