package com.flong.ecommerce.order;

import com.flong.ecommerce.address.AddressRequestDTO;

import java.math.BigDecimal;

public record OrderRequestDTO(
        Long userId,
        Long addressId,
        AddressRequestDTO billingAddressDTO,
        AddressRequestDTO shippingAddressDTO,
        BigDecimal totalAmount,
        BigDecimal totalWeight
) {
}
