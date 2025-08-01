package com.flong.ecommerce.authentication;

public record RegisterRequestDTO(
        String email,
        String password,
        String name,
        String phoneNumber,
        String address,
        String city,
        String state,
        String zipCode,
        String country,
        String role
) {
}
