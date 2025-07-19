package com.flong.ecommerce.cart;

import com.flong.ecommerce.cartitem.CartItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartMapper {

    private final CartItemMapper cartItemMapper;

    public CartResponseDTO toResponseDTO(Cart cart) {
        if (cart == null) {
            return null;
        }

        return new CartResponseDTO(
                cart.getId(),
                cart.getUser().getUsername(),
                cart.getItems()
                        .stream()
                        .map(cartItemMapper::toResponseDTO)
                        .toList()
        );
    }
}
