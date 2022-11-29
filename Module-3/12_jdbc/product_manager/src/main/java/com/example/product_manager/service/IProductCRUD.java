package com.example.product_manager.service;

import com.example.product_manager.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public interface IProductCRUD extends InterfaceCRUD<Product> {
    void search(HttpServletRequest request, HttpServletResponse response);
    void view(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException;
    void renderProduct(HttpServletRequest request, HttpServletResponse response, Product product) throws SQLException, ClassNotFoundException, ServletException, IOException;
}
