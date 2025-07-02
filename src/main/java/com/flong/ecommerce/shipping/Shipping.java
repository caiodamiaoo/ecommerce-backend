package com.flong.ecommerce.shipping;

import com.flong.ecommerce.order.Order;
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
@Table(name = "shipping")
@SequenceGenerator(name = "shipping_sequence", sequenceName = "shipping_id_seq", allocationSize = 1)
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipping_sequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "carrier", length = 100)
    private String carrier;

    @Column(name = "cost", nullable = false, precision = 12, scale = 2)
    private BigDecimal cost;

    @Column(name = "tracking_number", length = 100)
    private String trackingNumber;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "shipped_at")
    private LocalDateTime shippedAt;

    @Column(name = "delivered_at")
    private LocalDateTime deliveredAt;
}