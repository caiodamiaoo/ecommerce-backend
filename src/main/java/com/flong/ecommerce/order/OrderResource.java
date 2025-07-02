package com.flong.ecommerce.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderResource {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(OrderRequestDTO orderRequestDTO) {

        return ResponseEntity.ok(orderMapper.toResponseDTO(orderService.save(orderRequestDTO)));
    }
}
