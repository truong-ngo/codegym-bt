package com.example.backend.repository;

import com.example.backend.model.Category;
import com.example.backend.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends JpaRepository<Product, Long> {
    Iterable<Product> findAllByCategory(Category category);
    Iterable<Product> findAllByPriceBetween(Double start, Double end);
    Iterable<Product> findAllByPriceGreaterThan(Double start);
    Iterable<Product> findAllByNameContaining(String name);
    Iterable<Product> findAllByOrderByNameAsc();
    Iterable<Product> findAllByOrderByPriceAsc();
}
