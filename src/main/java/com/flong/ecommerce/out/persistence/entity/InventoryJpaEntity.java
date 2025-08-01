package com.flong.ecommerce.out.persistence.entity;

import com.flong.ecommerce.out.persistence.entity.id.InventoryId;
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
@Table(name = "inventory")
public class InventoryJpaEntity {

    @EmbeddedId
    private InventoryId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("warehouseId")
    @JoinColumn(name = "warehouse_id")
    private WarehouseJpaEntity warehouse;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}