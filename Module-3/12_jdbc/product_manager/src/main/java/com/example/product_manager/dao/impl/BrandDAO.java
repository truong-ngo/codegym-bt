package com.example.product_manager.dao.impl;

import com.example.product_manager.dao.IBrandDAO;
import com.example.product_manager.model.Brand;
import com.example.product_manager.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO implements IBrandDAO {
    private static BrandDAO instance;
    private String url = "jdbc:mysql://localhost:3306/product_manager";
    private String username = "root";
    private String password = "123456";

    private final String SELECT_ALL_BRANDS = "select * from brands";
    private final String SELECT_BRAND = " where id = ?";

    private BrandDAO() {
    }

    public static BrandDAO getInstance() {
        if (instance == null) {
            instance = new BrandDAO();
        }
        return instance;
    }

    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public Brand select(Long id) throws SQLException, ClassNotFoundException {
        Brand brand = null;
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BRANDS + SELECT_BRAND)) {
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String name = result.getString("name");
                brand = new Brand(id, name);
            }
        }
        return brand;
    }

    @Override
    public List<Brand> selectAll() throws SQLException, ClassNotFoundException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BRANDS)) {
            ResultSet result = statement.executeQuery();
            return generateList(result);
        }
    }

    @Override
    public void insert(Brand brand) throws SQLException, ClassNotFoundException {

    }

    @Override
    public boolean update(Long id, Brand brand) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    private List<Brand> generateList(ResultSet result) throws SQLException, ClassNotFoundException {
        List<Brand> brands = new ArrayList<>();
        while (result.next()) {
            Long id = result.getLong("id");
            String name = result.getString("name");
            brands.add(new Brand(id, name));
        }
        return brands;
    }
}
