package com.flong.ecommerce.authentication;

public record LoginRequestDTO(
        String email,
        String password
) {
}
