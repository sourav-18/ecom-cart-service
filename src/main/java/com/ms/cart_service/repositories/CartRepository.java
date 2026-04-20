package com.ms.cart_service.repositories;

import com.ms.cart_service.domins.Cart;
import com.ms.cart_service.domins.CartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    Optional<Cart> findByUserIdAndStatus(String userId, CartStatus status);

}
