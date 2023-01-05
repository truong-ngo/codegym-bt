package com.example.blog.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface IService<E, K> {
    Iterable<E> findAll();
    Optional<E> findById(K id);
    E save(E e);
    void remove(K id);
}
