package com.example.cart_complete.service.impl;

import com.example.cart_complete.model.Cart;
import com.example.cart_complete.model.CartDetails;
import com.example.cart_complete.model.Product;
import com.example.cart_complete.repository.ICartDetailsRepository;
import com.example.cart_complete.service.core.ICartDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CartDetailsService implements ICartDetailsService {
    private final ICartDetailsRepository cartDetailsRepository;

    @Autowired
    public CartDetailsService(ICartDetailsRepository cartDetailsRepository) {
        this.cartDetailsRepository = cartDetailsRepository;
    }

    @Override
    public Iterable<CartDetails> findAll() {
        return null;
    }

    @Override
    public Optional<CartDetails> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(CartDetails cartDetails) {
        cartDetailsRepository.save(cartDetails);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void deleteByProductAndCart(Product product, Cart cart) {
        cartDetailsRepository.deleteByProductAndCart(product, cart);
    }

    @Override
    public Iterable<CartDetails> findAllByCart(Cart cart) {
        return cartDetailsRepository.findAllByCart(cart);
    }

    public CartDetails checkProductInCart(Product product, Iterable<CartDetails> cartDetails) {
        for (CartDetails c : cartDetails) {
            if (Objects.equals(c.getProduct().getId(), product.getId())) {
                return c;
            }
        }
        return null;
    }
}
