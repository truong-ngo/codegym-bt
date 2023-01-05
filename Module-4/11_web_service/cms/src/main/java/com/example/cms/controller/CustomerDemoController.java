package com.example.cms.controller;

import com.example.cms.model.CustomerDemo;
import com.example.cms.service.ICustomerDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/customer")
public class CustomerDemoController {
    private final ICustomerDemoService customerDemoService;

    @Autowired
    public CustomerDemoController(ICustomerDemoService customerDemoService) {
        this.customerDemoService = customerDemoService;
    }

    @GetMapping
    public ResponseEntity<Iterable<CustomerDemo>> findAll() {
        List<CustomerDemo> customerDemos = (List<CustomerDemo>) customerDemoService.findAll();
        if (customerDemos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerDemos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDemo> findById(@PathVariable("id") Long id) {
        Optional<CustomerDemo> customerDemo = customerDemoService.findById(id);
        if (!customerDemo.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerDemo.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDemo> saveCustomer(@RequestBody CustomerDemo customerDemo) {
        return new ResponseEntity<>(customerDemoService.save(customerDemo), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDemo> updateCustomer(@PathVariable Long id, @RequestBody CustomerDemo customerDemo) {
        Optional<CustomerDemo> customerOptional = customerDemoService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerDemo.setId(customerOptional.get().getId());
        return new ResponseEntity<>(customerDemoService.save(customerDemo), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDemo> deleteCustomer(@PathVariable Long id) {
        Optional<CustomerDemo> customerOptional = customerDemoService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerDemoService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }
}
