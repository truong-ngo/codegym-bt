package com.example.upload_song.service;

import java.util.Optional;

public interface IService<E, K> {
    Iterable<E> findAll();
    Optional<E> findById(K id);
    void save(E e);
    void remove(K id);
}
