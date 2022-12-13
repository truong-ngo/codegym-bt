package com.example.sandwich.controller;

import com.example.sandwich.model.Sandwich;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {

    @PostMapping("/add")
    public ModelAndView add(Sandwich sandwich) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("lettuce", sandwich.getLettuce());
        modelAndView.addObject("tomato", sandwich.getTomato());
        modelAndView.addObject("mustard", sandwich.getMustard());
        modelAndView.addObject("sprouts", sandwich.getSprouts());
        return modelAndView;
    }
}
