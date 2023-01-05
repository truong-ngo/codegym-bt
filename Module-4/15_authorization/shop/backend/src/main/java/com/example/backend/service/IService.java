package com.example.backend.service;

import java.util.Optional;

public interface IService<K, V> {
    Iterable<K> findAll();
    Optional<K> findById(V id);
    K save(K k);
    void remove(V id);
}
