package com.example.cms.service;

import com.example.cms.model.CustomerDemo;
import com.example.cms.repository.ICustomerDemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerDemoService implements ICustomerDemoService {
    private final ICustomerDemoRepository customerDemoRepository;

    @Autowired
    public CustomerDemoService(ICustomerDemoRepository customerDemoRepository) {
        this.customerDemoRepository = customerDemoRepository;
    }


    @Override
    public Iterable<CustomerDemo> findAll() {
        return customerDemoRepository.findAll();
    }

    @Override
    public Optional<CustomerDemo> findById(Long id) {
        return customerDemoRepository.findById(id);
    }

    @Override
    public CustomerDemo save(CustomerDemo customerDemo) {
        return customerDemoRepository.save(customerDemo);
    }

    @Override
    public void remove(Long id) {
        customerDemoRepository.deleteById(id);
    }
}
