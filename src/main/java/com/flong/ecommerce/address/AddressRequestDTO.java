package com.flong.ecommerce.address;

public record AddressRequestDTO(
        String name,
        String phone,
        String address,
        String city,
        String state,
        String country,
        String zipCode
) {
}
