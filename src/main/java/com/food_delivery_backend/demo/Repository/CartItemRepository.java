package com.food_delivery_backend.demo.Repository;

import com.food_delivery_backend.demo.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    Optional<CartItem> findByIdAndCartId(Long id, Long itemId);
}
