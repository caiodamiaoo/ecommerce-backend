package com.flong.ecommerce.out.persistence.entity;

import com.flong.ecommerce.product.Product;
import com.flong.ecommerce.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "review")
@SequenceGenerator(name = "review_sequence", sequenceName = "review_id_seq", allocationSize = 1)
public class ReviewJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_sequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}