package com.example.form_data_binding.controller;

import com.example.form_data_binding.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class EmployeeController {
    @GetMapping("/form")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @RequestMapping("/add")
    public ModelAndView add(@ModelAttribute("employee") Employee employee) {
        ModelAndView modelAndView = new ModelAndView("info");
        modelAndView.addObject("name", employee.getName());
        modelAndView.addObject("contactNumber", employee.getContactNumber());
        modelAndView.addObject("id", employee.getId());
        return modelAndView;
    }
}
