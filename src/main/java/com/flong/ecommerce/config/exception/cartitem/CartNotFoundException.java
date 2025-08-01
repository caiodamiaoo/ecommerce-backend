package com.flong.ecommerce.config.exception.cartitem;

public class CartNotFoundException extends Exception {

    public CartNotFoundException(Long userId) {
        super("Cart not found with userId: " + userId);
    }
}
