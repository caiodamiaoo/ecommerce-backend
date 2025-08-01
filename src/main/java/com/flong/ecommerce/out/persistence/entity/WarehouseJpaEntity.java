package com.flong.ecommerce.out.persistence.entity;

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
@Table(name = "warehouse")
@SequenceGenerator(name = "warehouse_sequence", sequenceName = "warehouse_id_seq", allocationSize = 1)
public class WarehouseJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "warehouse_sequence")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "location", length = 255)
    private String location;
}