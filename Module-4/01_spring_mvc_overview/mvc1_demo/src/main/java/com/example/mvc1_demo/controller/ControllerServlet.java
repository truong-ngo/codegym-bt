package com.example.mvc1_demo.controller;

import com.example.mvc1_demo.form.ProductForm;
import com.example.mvc1_demo.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ControllerServlet", urlPatterns = {"/input-product", "/save-product"})
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1579L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);
        String dispatchUrl = null;
        if ("input-product".equals(action)) {
            dispatchUrl = "/views/ProductForm.jsp";
        } else if ("save-product".equals(action)) {
            ProductForm productForm = new ProductForm();
            productForm.setName(request.getParameter("name"));
            productForm.setDescription(request.getParameter("description"));
            productForm.setPrice(request.getParameter("price"));


            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            try {
                product.setPrice(Double.parseDouble(request.getParameter("price")));
            } catch (NumberFormatException exception) {
                exception.printStackTrace();
            }
            request.setAttribute("product", product);
            dispatchUrl = "/views/ProductDetails.jsp";
        }
        if (dispatchUrl != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(dispatchUrl);
            dispatcher.forward(request, response);
        }
    }
}
