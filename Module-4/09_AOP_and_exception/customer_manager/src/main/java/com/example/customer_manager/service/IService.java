package com.example.customer_manager.service;

import com.example.customer_manager.service.exception.DuplicateEmailException;

import java.util.List;

public interface IService<E, K> {
    List<E> findAll();
    E findById(K id);
    void save(E e) throws DuplicateEmailException;
    void remove(K id);
}
