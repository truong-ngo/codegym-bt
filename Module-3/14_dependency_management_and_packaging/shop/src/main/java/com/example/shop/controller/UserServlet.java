package com.example.shop.controller;

import com.example.shop.model.User;
import com.example.shop.service.impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/login")
public class UserServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    private final String MESS = "Wrong user or and password";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        controller(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        controller(request, response);
    }

    private void controller(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                login(request, response);
                break;
            default:
                toLoginPage(request, response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userService.checkUser(request);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("http://localhost:8080//");
        } else {
            request.setAttribute("mess", MESS);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
            dispatcher.forward(request, response);
        }
    }

    private void toLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/view/login/login.jsp");
    }
}
