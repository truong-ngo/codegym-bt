package com.example.customer_manager.repository;

import java.util.List;

public interface IRepository<E, K> {
    List<E> findAll();
    E findById(K id);
    void save(E e) throws Exception;
    void remove(K id);
}
