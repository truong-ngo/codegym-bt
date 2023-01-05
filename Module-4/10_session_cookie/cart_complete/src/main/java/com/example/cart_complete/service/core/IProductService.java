package com.example.cart_complete.service.core;

import com.example.cart_complete.model.Product;
import com.example.cart_complete.service.IService;

public interface IProductService extends IService<Product, Long> {
    String copyImage(Product product);
    String generateCode();
}
