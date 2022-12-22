package com.example.customer_manager.service;

import com.example.customer_manager.model.Customer;
import com.example.customer_manager.repository.ICustomerRepository;
import com.example.customer_manager.service.exception.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository;

    @Autowired
    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) throws DuplicateEmailException {
        try {
            customerRepository.save(customer);
        } catch (Exception e) {
            throw new DuplicateEmailException();
        }
    }

    @Override
    public void remove(Long id) {
        customerRepository.remove(id);
    }

    @Override
    public void insert(Customer customer) {
        customerRepository.insertWithStoredProcedure(customer);
    }
}
