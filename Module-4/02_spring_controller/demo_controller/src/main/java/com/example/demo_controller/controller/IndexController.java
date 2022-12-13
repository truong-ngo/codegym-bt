package com.example.demo_controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class IndexController {

    @GetMapping("/")
    public String get(Model model) {
        model.addAttribute("message", "home");
        return "/home";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("message", "index");
        return "/index";
    }
}
