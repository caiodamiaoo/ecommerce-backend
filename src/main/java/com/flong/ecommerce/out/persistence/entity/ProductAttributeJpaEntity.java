package com.flong.ecommerce.out.persistence.entity;

import com.flong.ecommerce.out.persistence.entity.id.ProductAttributeId;
import com.flong.ecommerce.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_attribute")
public class ProductAttributeJpaEntity {

    @EmbeddedId
    private ProductAttributeId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("attributeId")
    @JoinColumn(name = "attribute_id")
    private AttributeJpaEntity attribute;

    @Column(name = "value", length = 255)
    private String value;
}