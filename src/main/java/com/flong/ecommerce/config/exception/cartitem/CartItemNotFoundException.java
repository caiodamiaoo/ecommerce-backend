package com.flong.ecommerce.config.exception.cartitem;

public class CartItemNotFoundException extends Exception {

    public CartItemNotFoundException(Long cartId, Long productId) {
        super("CartItem not found with cartId: " + cartId + " and productId: " + productId);
    }
}
