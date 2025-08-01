package com.flong.ecommerce.ordercoupon;

import com.flong.ecommerce.order.Order;
import com.flong.ecommerce.out.persistence.entity.CouponJpaEntity;
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
@Table(name = "order_coupon")
public class OrderCouponJpaEntity {

    @EmbeddedId
    private OrderCouponId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("couponId")
    @JoinColumn(name = "coupon_id")
    private CouponJpaEntity coupon;
}