package com.example.product_manager.controller;

import com.example.product_manager.model.Product;
import com.example.product_manager.service.ProductService;
import com.example.product_manager.service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                searchProduct(request, response);
                break;
            case "view":
                listProducts(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "view":
                listProducts(request, response);
                break;
            case "search":
                searchProduct(request, response);
                break;
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        String username = request.getParameter("username");
        request.setAttribute("products", products);
        request.setAttribute("username", username);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/product.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");
        String supplier = request.getParameter("supplier");
        int id = products.get(products.size() - 1).getId() + 1;
        productService.add(new Product(id, name, price, description, supplier));
        listProducts(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");
        String supplier = request.getParameter("supplier");
        Product newProduct = new Product(id, name, price, description, supplier);
        productService.update(id, newProduct);
        listProducts(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.remove(id);
        listProducts(request, response);
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> searchList = new ArrayList<>();
        List<Product> products = productService.findAll();
        String search = request.getParameter("search").toLowerCase();
        String username = request.getParameter("username");
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(search)) {
                searchList.add(product);
            }
        }
        request.setAttribute("products", searchList);
        request.setAttribute("username", username);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/product.jsp");
        requestDispatcher.forward(request, response);
    }
}
