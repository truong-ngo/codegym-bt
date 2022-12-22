package com.example.customer_manager.service;

import com.example.customer_manager.model.Customer;

public interface ICustomerService extends IService<Customer, Long> {
    public void insert(Customer customer);
}
