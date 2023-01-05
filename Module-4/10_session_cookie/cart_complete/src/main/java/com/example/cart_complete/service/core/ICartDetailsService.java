package com.example.cart_complete.service.core;

import com.example.cart_complete.model.Cart;
import com.example.cart_complete.model.CartDetails;
import com.example.cart_complete.model.Product;
import com.example.cart_complete.service.IService;
import org.springframework.stereotype.Service;

public interface ICartDetailsService extends IService<CartDetails, Long> {
    void deleteByProductAndCart(Product product, Cart cart);
    Iterable<CartDetails> findAllByCart(Cart cart);
    CartDetails checkProductInCart(Product product, Iterable<CartDetails> cartDetails);
}
