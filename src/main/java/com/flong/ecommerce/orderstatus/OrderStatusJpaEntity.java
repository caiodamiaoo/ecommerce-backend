package com.flong.ecommerce.orderstatus;

import com.flong.ecommerce.order.Order;
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
@Table(name = "order_status")
@SequenceGenerator(name = "order_status_sequence", sequenceName = "order_status_id_seq", allocationSize = 1)
public class OrderStatusJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_status_sequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @Column(name = "changed_at", nullable = false)
    private LocalDateTime changedAt;
}