package com.example.customer_manager.service;

import java.util.List;

public interface IService<E, K> {
    List<E> findAll();
    E findById(K id);
    void save(E e);
    void remove(K id);
}
