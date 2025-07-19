package com.flong.ecommerce.cart;

import com.flong.ecommerce.cartitem.CartItemResponseDTO;

import java.util.List;

public record CartResponseDTO(
        Long id,
        String userName,
        List<CartItemResponseDTO> cartItems
) {
}
