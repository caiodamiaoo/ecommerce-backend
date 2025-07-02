package com.flong.ecommerce.order;

import com.flong.ecommerce.address.Address;
import com.flong.ecommerce.address.AddressService;
import com.flong.ecommerce.user.User;
import com.flong.ecommerce.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final AddressService addressService;

    public Order save(OrderRequestDTO dto) {
        User user = userService.getUserById(dto.userId());
        Address address = addressService.findAddressById(dto.addressId());
        Order order = new Order(user, address, address, dto.totalAmount());
        return orderRepository.save(order);
    }

    public Order findOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
