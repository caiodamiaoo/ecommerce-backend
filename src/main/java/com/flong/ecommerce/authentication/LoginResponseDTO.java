package com.flong.ecommerce.authentication;

public record LoginResponseDTO(String acessToken, Long expiresIn) {
}
