package com.example.cart_complete.service.core;

import com.example.cart_complete.model.Cart;
import com.example.cart_complete.model.CartDetails;
import com.example.cart_complete.model.Product;
import com.example.cart_complete.model.User;
import com.example.cart_complete.service.IService;

import java.util.Optional;

public interface ICartService extends IService<Cart, Long> {
    Optional<Cart> findByUser(User user);
}
