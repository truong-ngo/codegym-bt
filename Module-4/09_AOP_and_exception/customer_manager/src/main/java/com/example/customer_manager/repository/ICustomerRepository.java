package com.example.customer_manager.repository;

import com.example.customer_manager.model.Customer;

public interface ICustomerRepository extends IRepository<Customer, Long> {
    public void insertWithStoredProcedure(Customer customer);
}
