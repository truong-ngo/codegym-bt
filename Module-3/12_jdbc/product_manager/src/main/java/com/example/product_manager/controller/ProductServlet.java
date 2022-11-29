package com.example.product_manager.controller;

import com.example.product_manager.dao.impl.ProductDAO;
import com.example.product_manager.model.Product;
import com.example.product_manager.service.impl.ProductCRUD;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    ProductDAO productDAO = ProductDAO.getInstance();
    ProductCRUD productCRUD = ProductCRUD.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            controller(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            controller(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void controller(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                productCRUD.create(request, response);
                break;
            case "edit":
                productCRUD.update(request, response);
                break;
            case "delete":
                productCRUD.delete(request, response);
                break;
            case "view":
                productCRUD.view(request, response);
                break;
            default:
                List<Product> products = productDAO.selectAll();
                productCRUD.render(request, response, products);
        }
    }


}
