package com.example.cms.controller;

import com.example.cms.model.Customer;
import com.example.cms.model.Province;
import com.example.cms.service.ICustomerService;
import com.example.cms.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/province")
public class ProvinceController {
    private final IProvinceService provinceService;
    private final ICustomerService customerService;

    @Autowired
    public ProvinceController(IProvinceService provinceService, ICustomerService customerService) {
        this.provinceService = provinceService;
        this.customerService = customerService;
    }

    @GetMapping
    public ModelAndView list() {
        Iterable<Province> provinces = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("province/list");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView toForm() {
        ModelAndView modelAndView = new ModelAndView("province/form");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("province") Province province, RedirectAttributes redirect) {
        String message = (province.getId() != null) ? "Province updated successfully" :
                                                      "New province created successfully";
        provinceService.save(province);
        redirect.addFlashAttribute("message", message);
        return "redirect:/province";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView toForm(@PathVariable("id") Long id) {
        Optional<Province> province = provinceService.findById(id);
        ModelAndView modelAndView;
        if (province.isPresent()) {
            modelAndView = new ModelAndView("province/list");
            modelAndView.addObject("customer", province.get());
        } else {
            modelAndView = new ModelAndView("province/error.404");
        }
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirect) {
        Optional<Province> province = provinceService.findById(id);
        if (province.isPresent()) {
            provinceService.remove(id);
            redirect.addFlashAttribute("message", "Delete successfully");

        } else {
            redirect.addFlashAttribute("message", "Some thing went wrong");
        }
        return "redirect:/province";
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        Optional<Province> province = provinceService.findById(id);
        if(!province.isPresent()){
            return new ModelAndView("province/error.404");
        }

        Iterable<Customer> customers = customerService.findAllByProvince(province.get());

        ModelAndView modelAndView = new ModelAndView("province/view");
        modelAndView.addObject("province", province.get());
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
