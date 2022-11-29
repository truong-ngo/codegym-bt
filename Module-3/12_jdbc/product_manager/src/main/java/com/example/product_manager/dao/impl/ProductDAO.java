package com.example.product_manager.dao.impl;

import com.example.product_manager.dao.IProductDAO;
import com.example.product_manager.model.Brand;
import com.example.product_manager.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private static ProductDAO instance;
    private String url = "jdbc:mysql://localhost:3306/product_manager";
    private String username = "root";
    private String password = "123456";

    private final String SELECT_ALL_PRODUCTS = "select * from products";
    private final String SELECT_PRODUCT = " where id = ?";
    private final String INSERT_PRODUCT = "insert into products (name, price, description, brand_id) values (?, ?, ?, ?);";
    private final String UPDATE_PRODUCT = "update products set name = ?, price = ?, description = ?, brand_id = ?";
    private static final String DELETE_PRODUCT = "delete from products where id = ?;";

    private ProductDAO() {

    }

    public static ProductDAO getInstance() {
        if (instance == null) {
            instance = new ProductDAO();
        }
        return instance;
    }

    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public Product select(Long id) throws SQLException, ClassNotFoundException {
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PRODUCTS + SELECT_PRODUCT)) {
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            Product product = null;
            while (result.next()) {
                String name = result.getString("name");
                Double price = result.getDouble("price");
                String description = result.getString("description");
                Brand brand = BrandDAO.getInstance().select(result.getLong("brand_id"));
                product = new Product(id, name, price, description, brand);
            }
            return product;
        }
    }

    @Override
    public List<Product> selectAll() throws SQLException, ClassNotFoundException {
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PRODUCTS)) {
            ResultSet result = statement.executeQuery();
            return generateList(result);
        }
    }

    @Override
    public void insert(Product product) throws SQLException, ClassNotFoundException {
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCT)) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setString(3, product.getDescription());
            statement.setLong(4, product.getBrand().getId());
            statement.executeUpdate();
        }
    }

    @Override
    public boolean update(Long id, Product product) throws SQLException, ClassNotFoundException {
        int check;
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT + SELECT_PRODUCT)) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setString(3, product.getDescription());
            statement.setLong(4, product.getBrand().getId());
            statement.setLong(5, id);
            check = statement.executeUpdate();
        }
        return check > 0;
    }

    @Override
    public boolean delete(Long id) throws SQLException, ClassNotFoundException {
        int check;
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT)) {
            statement.setLong(1, id);
            check = statement.executeUpdate();
        }
        return check > 0;
    }

    private List<Product> generateList(ResultSet result) throws SQLException, ClassNotFoundException {
        List<Product> products = new ArrayList<>();
        while (result.next()) {
            Long id = result.getLong("id");
            String name = result.getString("name");
            Double price = result.getDouble("price");
            String description = result.getString("description");
            Brand brand = BrandDAO.getInstance().select(result.getLong("brand_id"));
            products.add(new Product(id, name, price, description, brand));
        }
        return products;
    }
}
