package com.example.customer_manager.controller;

import com.example.customer_manager.model.Customer;
import com.example.customer_manager.service.ICustomerService;
import com.example.customer_manager.service.exception.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    private final ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("index", "customers", customerService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView toCreateForm() {
        return new ModelAndView("create", "customer", new Customer());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("customer") Customer customer, RedirectAttributes redirect) throws DuplicateEmailException {
        customerService.save(customer);
        redirect.addFlashAttribute("message", "New customer created successfully");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } else {
            return new ModelAndView("error.404");
        }
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("customer") Customer customer, RedirectAttributes redirect) throws DuplicateEmailException {
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Customer updated successfully");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id, RedirectAttributes redirect) {
        customerService.remove(id);
        redirect.addFlashAttribute("message", "Delete successfully");
        return "redirect:/";
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("inputs-not-acceptable");
    }
}
