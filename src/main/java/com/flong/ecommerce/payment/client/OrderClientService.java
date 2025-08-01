package com.flong.ecommerce.payment.client;

import com.flong.ecommerce.order.Order;
import com.flong.ecommerce.order.OrderService;
import com.flong.ecommerce.payment.PaymentRequestDTO;
import com.flong.ecommerce.payment.PaymentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.flong.ecommerce.payment.client.pix.PixClientMapper.paymentRequestDtoToPixRequest;
import static com.flong.ecommerce.payment.client.pix.PixClientMapper.pixResponseToPaymentResponseDTO;

@Service
@RequiredArgsConstructor
public class OrderClientService {

    private final OrderFeignClient orderFeignClient;
    private final OrderService orderService;

    public PaymentResponseDTO createOrderPix(PaymentRequestDTO paymentRequestDTO) {

        Order order = orderService.findOrderById(paymentRequestDTO.orderId());
        return pixResponseToPaymentResponseDTO(orderFeignClient.createOrder(paymentRequestDtoToPixRequest(order)));
    }
}
