package com.example.shop.dao;

import com.example.shop.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IUserDAO extends InterfaceDAO<User, Long> {
    User selectByName(String name) throws SQLException, ClassNotFoundException;
    User generateUser(ResultSet result) throws SQLException;
    List<User> generateList(ResultSet result) throws SQLException;
}
