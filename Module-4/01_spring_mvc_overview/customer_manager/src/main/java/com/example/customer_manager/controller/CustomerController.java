package com.example.customer_manager.controller;

import com.example.customer_manager.model.Customer;
import com.example.customer_manager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService service;

    @RequestMapping("/customers")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> customers = service.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @RequestMapping("/info")
    public ModelAndView showDetails(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("info");
        Long id = Long.parseLong(request.getParameter("id"));
        Customer customer = service.findOne(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @RequestMapping("/update")
    public ModelAndView update(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "email", required = false) String email, @RequestParam(value = "address", required = false) String address) {
        ModelAndView modelAndView = new ModelAndView("list");
        Customer customer = new Customer(id, name, email, address);
        service.save(customer);
        List<Customer> customers = service.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
