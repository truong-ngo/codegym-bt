package com.example.blog.repository;

import java.util.List;

public interface IRepository<E, K> {
    List<E> findAll();
    E findById(K id);
    void save(E e);
    void remove(K id);
}
