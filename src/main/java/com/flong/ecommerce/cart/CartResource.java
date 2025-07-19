package com.flong.ecommerce.cart;

import com.flong.ecommerce.config.exception.cartitem.CartItemNotFoundException;
import com.flong.ecommerce.config.exception.cartitem.CartNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cart")
public class CartResource {

    private final CartService cartService;

    private final CartMapper cartMapper;

    @GetMapping("/{userId}")
    public ResponseEntity<CartResponseDTO> getCart(@PathVariable Long userId) {
        return ResponseEntity.ok(cartMapper.toResponseDTO(cartService.getCartByUserId(userId)));
    }

    @PostMapping("/{userId}/add/{productId}")
    public ResponseEntity<CartResponseDTO> addItemToCart(@PathVariable Long userId, @PathVariable Long productId) {
        return ResponseEntity.ok(cartMapper.toResponseDTO(cartService.addItemToCart(userId, productId)));
    }

    @DeleteMapping("/{userId}/remove/{cartItemId}")
    public ResponseEntity<CartResponseDTO> removeItemFromCart(@PathVariable Long userId, @PathVariable Long cartItemId) throws CartItemNotFoundException, CartNotFoundException {
        return ResponseEntity.ok(cartMapper.toResponseDTO(cartService.removeItemFromCart(userId, cartItemId)));
    }

    @DeleteMapping("/{userId}/clear")
    public ResponseEntity<CartResponseDTO> clearCart(@PathVariable Long userId) throws CartNotFoundException {
        return ResponseEntity.ok(cartMapper.toResponseDTO(cartService.clearCart(userId)));
    }

    @PutMapping("/{userId}/update/{cartItemId}")
    public ResponseEntity<CartResponseDTO> updateItemQuantity(@PathVariable Long userId, @PathVariable Long cartItemId, @RequestParam int quantity) throws CartItemNotFoundException, CartNotFoundException {
        return ResponseEntity.ok(cartMapper.toResponseDTO(cartService.updateItemQuantity(userId, cartItemId, quantity)));
    }
}
