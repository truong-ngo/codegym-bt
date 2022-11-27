package com.example.simple_login;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        if (username.equals("admin") && password.equals("123456")) {
            out.println("<h1>Welcome " + username + " to website</h1>");
        } else {
            out.println("<h1>Login Error</h1>");
        }

        out.println("</body></html>");
    }

    public void destroy() {
    }
}