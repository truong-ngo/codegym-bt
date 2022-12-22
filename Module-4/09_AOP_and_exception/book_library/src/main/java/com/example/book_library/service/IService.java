package com.example.book_library.service;

import com.example.book_library.service.exception.BookException;

import java.util.Optional;

public interface IService<E, K> {
    Iterable<E> findAll();
    Optional<E> findById(K id);
    void save(E e) throws Exception;
    void remove(K id);
}
