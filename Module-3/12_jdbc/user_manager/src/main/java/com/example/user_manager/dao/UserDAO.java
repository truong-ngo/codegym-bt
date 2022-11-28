package com.example.user_manager.dao;

import com.example.user_manager.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements InterfaceDAO<User> {
    private String url = "jdbc:mysql://localhost:3306/jdbc_demo";
    private String username = "root";
    private String password = "123456";

    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, country) VALUES (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id = ?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String SORT_USERS = "select * from users order by ";

    public UserDAO() {
    }

    protected Connection getConnection() {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException exception) {
            throw new RuntimeException(exception);
        }
        return connection;
    }

    @Override
    public void insert(User user) throws SQLException {
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_USERS_SQL)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public User select(int id) {
        User user = null;
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String name = result.getString("name");
                String email = result.getString("email");
                String country = result.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                String country = result.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(int id, User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, id);
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public List<User> sort(String item) throws SQLException {
        List<User> sortList = new ArrayList<>();
        Connection connection = getConnection();
        String statementStr = SORT_USERS + item;
        PreparedStatement statement = connection.prepareStatement(statementStr);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            String email = result.getString("email");
            String country = result.getString("country");
            sortList.add(new User(id, name, email, country));
        }
        connection.close();
        return sortList;
    }
}
