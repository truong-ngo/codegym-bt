package com.example.cart_complete.repository;

import com.example.cart_complete.model.Cart;
import com.example.cart_complete.model.CartDetails;
import com.example.cart_complete.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartDetailsRepository extends JpaRepository<CartDetails, Long> {
    void deleteByProductAndCart(Product product, Cart cart);
    Iterable<CartDetails> findAllByCart(Cart cart);
}
