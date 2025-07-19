package com.flong.ecommerce.cartitem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, CartItemId> {
    CartItem findByCartIdAndProductId(Long cartId, Long productId);

    List<CartItem> findAllByCart_Id(Long cartId);
}
