package com.example.product_manager.service.impl;

import com.example.product_manager.model.Manufacturer;
import com.example.product_manager.model.Product;
import com.example.product_manager.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProductService implements IProductService {
    private static final Map<Long, Product> products;
    public static final ManufacturerService manufacturerService = ManufacturerService.getInstance();

    public Long getLastIndex() {
        Set<Long> keys = products.keySet();
        return (long) keys.size();
    }

    static {
        products = new TreeMap<>();
        products.put(1L, new Product(1L, "Pixel 7", 599, "Sage", manufacturerService.findByName("Google").get(0)));
        products.put(2L, new Product(2L, "Galaxy S22", 699, "Blue", manufacturerService.findByName("Samsung").get(0)));
        products.put(3L, new Product(3L, "iPhone 14", 999, "Rose", manufacturerService.findByName("Apple").get(0)));
    }



    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : findAll()) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(Long id) {
        return products.get(id);
    }

    @Override
    public void insert(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(Long id, Product product) {
        products.put(id, product);
    }

    @Override
    public void delete(Long id) {
        products.remove(id);
    }
}
