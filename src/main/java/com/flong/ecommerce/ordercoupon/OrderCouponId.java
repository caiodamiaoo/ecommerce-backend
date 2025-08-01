package com.flong.ecommerce.ordercoupon;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderCouponId implements Serializable {
    private Long orderId;
    private Long couponId;
}