package com.flong.ecommerce.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coupon")
@SequenceGenerator(name = "coupon_sequence", sequenceName = "coupon_id_seq", allocationSize = 1)
public class CouponJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coupon_sequence")
    private Long id;

    @Column(name = "code", nullable = false, unique = true, length = 50)
    private String code;

    @Column(name = "discount_type", nullable = false, length = 20)
    private String discountType;

    @Column(name = "discount_value", nullable = false, precision = 12, scale = 2)
    private BigDecimal discountValue;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @Column(name = "usage_limit")
    private Integer usageLimit;

    @Column(name = "used_count")
    private Integer usedCount;
}