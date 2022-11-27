package com.example.customers;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Customers", value = "/customers")
public class Customers extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Son", "11-12-1995", "Ha Noi", "https://cdn1.iconfinder.com/data/icons/ninja-things-1/1772/ninja-simple-512.png"));
        customers.add(new Customer("Duc", "06-07-1996", "Ha Noi", "https://cdn1.iconfinder.com/data/icons/ninja-things-1/1772/ninja-simple-512.png"));
        customers.add(new Customer("Tung", "14-03-1997", "Ha Noi", "https://cdn1.iconfinder.com/data/icons/ninja-things-1/1772/ninja-simple-512.png"));
        customers.add(new Customer("Minh", "26-06-1999", "Ha Noi", "https://cdn1.iconfinder.com/data/icons/ninja-things-1/1772/ninja-simple-512.png"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        request.setAttribute("customers", customers);
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}