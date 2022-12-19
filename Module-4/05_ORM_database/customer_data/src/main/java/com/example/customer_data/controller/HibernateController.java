package com.example.customer_data.controller;

import com.example.customer_data.model.Customer;
import com.example.customer_data.service.HibernateCustomerService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class HibernateController {
    @Autowired
    private HibernateCustomerService service;

    @GetMapping
    public String index(Model model) {
        List<Customer> customers = service.findAll();
        model.addAttribute("customers", customers);
        return "index";
    }

    @GetMapping("/update")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/update")
    public String update(Customer customer, RedirectAttributes attributes) {
        int id = customer.getId();
        service.update(id, customer);
        attributes.addFlashAttribute("success",  "Customer was successfully update.");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", service.findById(id));
        return "create";
    }

}
