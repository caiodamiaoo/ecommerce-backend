package com.flong.ecommerce.cartitem;

import com.flong.ecommerce.config.exception.cartitem.CartItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public void remove(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }

    public CartItem findById(Long cartId, Long productId) throws CartItemNotFoundException {
        return Optional.ofNullable(cartItemRepository.findByCartIdAndProductId(cartId, productId))
                .orElseThrow(() -> new CartItemNotFoundException(cartId, productId));
    }

    public List<CartItem> findAllByCartId(Long cartId) {
        return cartItemRepository.findAllByCart_Id(cartId);
    }
}
