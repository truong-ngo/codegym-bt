package com.example.currency_converter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConverterController {
    @GetMapping("/")
    public ModelAndView toIndex() {
        return new ModelAndView("index");
    }

    @PostMapping("/convert")
    public ModelAndView convert(@RequestParam String usd_amount) {
        ModelAndView modelAndView = new ModelAndView("index");
        String mess = null;
        Double usd = null;
        double vnd;
        try {
            usd = Double.parseDouble(usd_amount);
        } catch (Exception exception) {
            mess = "Invalid input";
        }
        if (usd != null) {
            vnd = usd * 23000;
            mess = Double.toString(vnd);
        }
        modelAndView.addObject("mess", mess);
        return modelAndView;
    }
}
