package com.example.demo.controller.rest;

import com.example.demo.model.Customer;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerRestController {
    private final ICustomerService customerService;

    @Autowired
    public CustomerRestController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("findById/{id}")
    public Customer findById(@PathVariable("id") Long id) {
        return customerService.findById(id).get();
    }

    @PostMapping("customer")
    public Customer saveCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return customer;
    }
}
