package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.service.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    private final CustomerService customerService = new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "view":
                listCustomers(request, response);
                break;
        }
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerService.findAll();
        String username = request.getParameter("username");
        request.setAttribute("customers", customers);
        request.setAttribute("username", username);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerService.findAll();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id = customers.get(customers.size() - 1).getId() + 1;
        customerService.update(id, new Customer(id, name, email, address));
        listCustomers(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = customerService.findById(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        listCustomers(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.remove(id);
        listCustomers(request, response);
    }
}
