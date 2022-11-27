package com.example.currency_converter;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "converter", value = "/converter")
public class Converter extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        double usd = Double.parseDouble(request.getParameter("usd"));
        double rate = Double.parseDouble(request.getParameter("rate"));
        double vnd = rate * usd;
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        request.setAttribute("vnd", vnd);
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }
}