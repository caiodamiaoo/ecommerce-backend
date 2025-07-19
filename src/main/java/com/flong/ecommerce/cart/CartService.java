package com.flong.ecommerce.cart;

import com.flong.ecommerce.cartitem.CartItem;
import com.flong.ecommerce.cartitem.CartItemService;
import com.flong.ecommerce.config.exception.cartitem.CartItemNotFoundException;
import com.flong.ecommerce.config.exception.cartitem.CartNotFoundException;
import com.flong.ecommerce.product.Product;
import com.flong.ecommerce.product.ProductService;
import com.flong.ecommerce.user.User;
import com.flong.ecommerce.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final UserService userService;
    private final ProductService productService;
    private final CartItemService cartItemService;

    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public Cart addItemToCart(Long userId, Long productId) {
        Cart cartUser = cartRepository.saveAndFlush(
                Optional.ofNullable(getCartByUserId(userId))
                        .orElseGet(() -> {
                            User user = userService.getUserById(userId);
                            return new Cart(user);
                        }));
        Product product = productService.findById(productId);
        CartItem cartItem = cartItemService.save(new CartItem(cartUser, product, 1));
        cartUser.getItems().add(cartItem);
        return cartUser;
    }

    public Cart removeItemFromCart(Long userId, Long productId) throws CartItemNotFoundException, CartNotFoundException {
        Cart cart = Optional.ofNullable(getCartByUserId(userId))
                .orElseThrow(() -> new CartNotFoundException(userId));
        CartItem item = cartItemService.findById(userId, productId);
        cartItemService.remove(item);
        cart.getItems().removeIf(i -> i.getProduct().getId().equals(productId));
        return cartRepository.save(cart);
    }

    public Cart clearCart(Long userId) throws CartNotFoundException {
        Cart cart = Optional.ofNullable(getCartByUserId(userId))
                .orElseThrow(() -> new CartNotFoundException(userId));
        cart.getItems().clear();
        cartItemService.findAllByCartId(cart.getId())
                .forEach(cartItemService::remove);
        return cartRepository.save(cart);
    }

    public Cart updateItemQuantity(Long userId, Long productId, Integer quantity) throws CartItemNotFoundException, CartNotFoundException {
        Cart cart = Optional.ofNullable(getCartByUserId(userId))
                .orElseThrow(() -> new CartNotFoundException(userId));
        CartItem item = cartItemService.findById(userId, productId);
        item.setQuantity(item.getQuantity() + quantity);
        if (item.getQuantity() <= 0) {
            cart.getItems().removeIf(i -> i.getProduct().getId().equals(productId));
            cartItemService.remove(item);
        } else {
            cart.getItems().add(item);
            cartItemService.save(item);
        }
        return cart;
    }
}
