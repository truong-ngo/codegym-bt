package com.example.cms.service;

import java.util.Optional;

public interface IService<E, K> {
    Iterable<E> findAll();
    Optional<E> findById(K id);
    E save(E e);
    void remove(K id);
}
