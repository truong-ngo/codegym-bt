package com.example.shop.dao.impl;

import com.example.shop.dao.IUserDAO;
import com.example.shop.dao.MyConnection;
import com.example.shop.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private static UserDAO instance;
    private final String SELECT_USER_BY_NAME = "select * from user where name = ?;";

    private UserDAO() {
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    @Override
    public User select(Long id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<User> selectAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public void insert(User user) throws SQLException, ClassNotFoundException {

    }

    @Override
    public boolean update(Long id, User user) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(Long id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public User selectByName(String name) throws SQLException, ClassNotFoundException {
        User user;
        try (Connection connection = MyConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_NAME)) {
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            user = generateUser(result);
        }
        return user;
    }

    @Override
    public User generateUser(ResultSet result) throws SQLException {
        List<User> users = generateList(result);
        return users.get(0);
    }

    @Override
    public List<User> generateList(ResultSet result) throws SQLException {
        List<User> users = new ArrayList<>();
        while (result.next()) {
            Long id = result.getLong("id");
            String role = result.getString("role");
            String username = result.getString("username");
            String password = result.getString("password");
            String phoneNumber = result.getString("phone_number");
            String address = result.getString("address");
            String url = result.getString("url");
            users.add(new User(id, role, username, password, phoneNumber, address, url));
        }
        return users;
    }
}
