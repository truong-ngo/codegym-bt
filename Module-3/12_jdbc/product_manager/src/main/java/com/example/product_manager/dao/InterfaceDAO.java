package com.example.product_manager.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<E, K> {
    E select(K id) throws SQLException, ClassNotFoundException;
    List<E> selectAll() throws SQLException, ClassNotFoundException;
    void insert (E e) throws SQLException, ClassNotFoundException;
    boolean update(K id, E e) throws SQLException, ClassNotFoundException;
    boolean delete(K id) throws SQLException, ClassNotFoundException;
}
