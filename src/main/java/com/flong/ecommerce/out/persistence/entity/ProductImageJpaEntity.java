package com.flong.ecommerce.out.persistence.entity;

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
@Table(name = "product_image")
@SequenceGenerator(name = "product_image_sequence", sequenceName = "product_image_id_seq", allocationSize = 1)
public class ProductImageJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_image_sequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "alt_text", length = 150)
    private String altText;

    @Column(name = "sort_order")
    private Integer sortOrder;
}