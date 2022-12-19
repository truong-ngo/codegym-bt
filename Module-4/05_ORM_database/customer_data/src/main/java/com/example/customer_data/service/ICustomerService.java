package com.example.customer_data.service;

import com.example.customer_data.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer save(Customer customer);
    Customer findById(int id);
    void update(int id, Customer customer);
    void remove(int id);
}
