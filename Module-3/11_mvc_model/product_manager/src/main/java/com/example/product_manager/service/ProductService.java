package com.example.product_manager.service;

import com.example.product_manager.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void add(Product product);
    Product findById(int id);
    void update(int id, Product product);
    void remove(int id);
}
