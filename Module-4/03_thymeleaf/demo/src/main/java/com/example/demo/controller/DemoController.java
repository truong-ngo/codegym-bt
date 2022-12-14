package com.example.demo.controller;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {
    @GetMapping("/hello")
    public ModelAndView demo() {
        return new ModelAndView("demo");
    }

    @GetMapping("/conditional")
    public ModelAndView conditionalExample() {
        return new ModelAndView("conditional");
    }

    @GetMapping("/expression")
    public ModelAndView expressionExample() {
        ModelAndView modelAndView = new ModelAndView("expression");
        String name = "CodeGym";
        Customer customer = new Customer(1L, "Truong");
        modelAndView.addObject("name", name);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @GetMapping("/variable")
    public ModelAndView variable() {
        ModelAndView modelAndView = new ModelAndView("variable");
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1L, "Truong"));
        customers.add(new Customer(2L, "Thuy"));
        customers.add(new Customer(3L, "Bon"));
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
 }
