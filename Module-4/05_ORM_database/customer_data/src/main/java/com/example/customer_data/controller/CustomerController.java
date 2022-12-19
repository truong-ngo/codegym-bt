package com.example.customer_data.controller;

import com.example.customer_data.model.Customer;
import com.example.customer_data.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private LocalContainerEntityManagerFactoryBean entityManagerFactory;

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes attributes) {
        int id = customerService.getLastIndex() + 1;
        customer.setId(id);
        customerService.save(customer);
        attributes.addFlashAttribute("success",  "Customer was successfully added.");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "create";
    }

    @PostMapping("/update")
    public String update(Customer customer, RedirectAttributes attributes) {
        int id = customer.getId();
        customerService.update(id, customer);
        attributes.addFlashAttribute("success",  "Customer was successfully update.");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "index";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes attributes) {
        customerService.remove(id);
        attributes.addFlashAttribute("success",  "Customer was successfully remove.");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "view";
    }
}
