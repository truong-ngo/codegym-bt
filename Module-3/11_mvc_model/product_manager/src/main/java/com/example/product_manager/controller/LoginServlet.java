package com.example.product_manager.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private final String ADMIN = "admin";
    private final String USER = "user";
    private final String AD_PASS = "123456";
    private final String U_PASS = "654321";
    private final String MESS = "Wrong username or password";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals(ADMIN) && password.equals(AD_PASS)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/product?username=" + username + "&action=view");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("mess", MESS);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
