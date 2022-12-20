package com.example.cms.controller;

import com.example.cms.model.Customer;
import com.example.cms.model.Province;
import com.example.cms.service.ICustomerService;
import com.example.cms.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final ICustomerService customerService;
    private final IProvinceService provinceService;

    @Autowired
    public CustomerController(ICustomerService customerService, IProvinceService provinceService) {
        this.customerService = customerService;
        this.provinceService = provinceService;
    }

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping
    public ModelAndView list(@PageableDefault(value = 1) Pageable pageable) {
        Iterable<Customer> customers = customerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customers);
        String name = "";
        modelAndView.addObject("search", Optional.of(name));
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView toForm() {
        ModelAndView modelAndView = new ModelAndView("customer/form");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer") Customer customer, RedirectAttributes redirect) {
        String message = (customer.getId() != null) ? "Customer updated successfully" :
                                                      "New customer created successfully";
        customerService.save(customer);
        redirect.addFlashAttribute("message", message);
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView toForm(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerService.findById(id);
        ModelAndView modelAndView;
        if (customer.isPresent()) {
            modelAndView = new ModelAndView("customer/form");
            modelAndView.addObject("customer", customer.get());
        } else {
            modelAndView = new ModelAndView("customer/error.404");
        }
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirect) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            customerService.remove(id);
            redirect.addFlashAttribute("message", "Delete successfully");

        } else {
            redirect.addFlashAttribute("message", "Some thing went wrong");
        }
        return "redirect:/customer";
    }

    @GetMapping("/search")
    public ModelAndView list(@RequestParam("search") Optional<String> search, @PageableDefault(value = 1) Pageable pageable){
        Page<Customer> customers;
        if(search.isPresent()){
            customers = customerService.findAllByFirstNameContaining(search.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("search", search);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
