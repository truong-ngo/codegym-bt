package com.example.backend.service.core;

import com.example.backend.model.Category;
import com.example.backend.model.Product;
import com.example.backend.service.IService;

public interface IProductService extends IService<Product, Long> {
    Product copyFile(Product product);
    Iterable<Product> findAllByCategory(Category category);
    Iterable<Product> findAllByPriceBetween(Double start, Double end);
    Iterable<Product> findAllByPriceGreaterThan(Double start);
    Iterable<Product> findAllByNameContaining(String name);
    Iterable<Product> findAllByOrderByNameAsc();
    Iterable<Product> findAllByOrderByPriceAsc();
}
