package com.flong.ecommerce.cartitem;

import org.springframework.stereotype.Component;

@Component
public class CartItemMapper {

    public CartItemResponseDTO toResponseDTO(CartItem cartItem) {

        return new CartItemResponseDTO(
                cartItem.getId().getCartId(),
                cartItem.getId().getProductId(),
                cartItem.getProduct().getName(),
                cartItem.getPrice()
        );
    }
}
