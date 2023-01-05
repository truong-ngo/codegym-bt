package com.example.cart_complete.repository;

import com.example.cart_complete.model.Cart;
import com.example.cart_complete.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);
}
