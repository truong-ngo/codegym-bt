package com.example.demo_login;

import java.io.*;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "UserLogin", value = "/user-login")
public class UserLogin extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("admin") && password.equals("123456")) {
            request.setAttribute("loginTime", LocalDate.now());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login-successful.jsp");
            requestDispatcher.forward(request, response);
        } else {
            String error = "Wrong username or password";
            request.setAttribute("error", error);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    public void destroy() {
    }
}