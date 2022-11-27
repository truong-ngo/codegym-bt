package com.example.product_manager.service;

import com.example.product_manager.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static final List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "Pixel 7", 600, "Sage", "Google"));
        products.add(new Product(2, "Iphone 14", 900, "Gold", "Apple"));
        products.add(new Product(3, "Galaxy Fold 4", 1200, "Black", "Samsung"));
        products.add(new Product(4, "Xiaomi 12", 700, "Gradient", "Xiaomi"));
        products.add(new Product(5, "One Plus 10", 800, "Rose", "One Plus"));
        products.add(new Product(6, "ROG Phone 6", 1100, "White", "Asus"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id - 1);
    }

    @Override
    public void update(int id, Product updateProduct) {
        products.set(id - 1, updateProduct);
    }

    @Override
    public void remove(int id) {
        products.remove(id - 1);
    }
}
