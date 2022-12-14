package com.example.product_manager.service;

import com.example.product_manager.model.Product;

import java.util.List;

public interface IProductService extends IService<Product, Long> {
    List<Product> findByName(String name);
}
