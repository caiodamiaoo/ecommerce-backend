package com.flong.ecommerce.payment.client;

import com.flong.ecommerce.payment.client.pix.PixRequest;
import com.flong.ecommerce.payment.client.pix.PixResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "Order", url = "https://api.pagar.me/core/v5")
public interface OrderFeignClient {

    @PostMapping("/orders")
    PixResponse createOrder(PixRequest pixRequest);
}
