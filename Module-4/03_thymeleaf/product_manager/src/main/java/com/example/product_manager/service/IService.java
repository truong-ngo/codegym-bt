package com.example.product_manager.service;

import java.util.List;

public interface IService<E, K> {
    List<E> findAll();
    E findById(K id);
    void insert(E e);
    void update(K k, E e);
    void delete(K k);
}
