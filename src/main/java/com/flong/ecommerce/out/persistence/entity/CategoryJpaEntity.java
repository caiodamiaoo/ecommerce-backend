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
@Table(name = "category")
@SequenceGenerator(name = "category_sequence", sequenceName = "category_id_seq", allocationSize = 1)
public class CategoryJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "slug", nullable = false, unique = true, length = 100)
    private String slug;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private CategoryJpaEntity parent;
}