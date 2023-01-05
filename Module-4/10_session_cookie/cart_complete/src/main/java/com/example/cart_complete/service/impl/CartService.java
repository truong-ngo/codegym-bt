package com.example.cart_complete.service.impl;

import com.example.cart_complete.model.Cart;
import com.example.cart_complete.model.CartDetails;
import com.example.cart_complete.model.Product;
import com.example.cart_complete.model.User;
import com.example.cart_complete.repository.ICartRepository;
import com.example.cart_complete.service.core.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class CartService implements ICartService {
    private final ICartRepository cartRepository;

    @Autowired
    public CartService(ICartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Iterable<Cart> findAll() {
        return null;
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Optional<Cart> findByUser(User user) {
        return cartRepository.findByUser(user);
    }
}
