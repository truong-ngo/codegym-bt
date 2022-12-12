package com.example.mvc2_demo.controller;

import com.example.mvc2_demo.form.ProductForm;
import com.example.mvc2_demo.model.Product;
import com.example.mvc2_demo.validator.ProductValidator;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "DispatcherFilter", urlPatterns = {"/input-product", "/save-product"})
public class DispatcherFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
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

            ProductValidator validator = new ProductValidator();
            List<String> errors = validator.validate(productForm);
            if (errors.isEmpty()) {
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
            } else {
                request.setAttribute("errors", errors);
                request.setAttribute("form", productForm);
                dispatchUrl = "/views/ProductForm.jsp";
            }
        }

        if (dispatchUrl != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(dispatchUrl);
            dispatcher.forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }
}
