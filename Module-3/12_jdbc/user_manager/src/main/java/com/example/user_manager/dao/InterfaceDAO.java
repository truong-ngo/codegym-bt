package com.example.user_manager.dao;

import com.example.user_manager.model.User;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<E> {
    void insert(E e) throws SQLException;
    E select(int id);
    List<E> selectAll();
    boolean delete(int id) throws SQLException;
    boolean update(int id, User user) throws SQLException;
    E getById(int id) throws SQLException;
    void insertStored(E e) throws SQLException;
    void addUserTransaction(User user, int[] permission) throws SQLException;
    void insertUpdateWithoutTransaction() throws SQLException;
    public void insertUpdateUseTransaction() throws SQLException;
    List<E> selectAllStored() throws SQLException;
    boolean deleteStored(int id) throws SQLException;
    boolean updateStored(int id, User user) throws SQLException;
}
