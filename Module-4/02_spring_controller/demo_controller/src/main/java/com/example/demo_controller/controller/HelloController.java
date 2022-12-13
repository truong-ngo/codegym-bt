package com.example.demo_controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String handle(Model model) {
        model.addAttribute("message", "Hello world");
        return "index";
    }

    @RequestMapping("/view?/inf?")
    public String view(Model model) {
        model.addAttribute("message", "Question");
        return "index";
    }

    @RequestMapping("/vi*/ind*")
    public String test(Model model) {
        model.addAttribute("message", "All");
        return "index";
    }

    @RequestMapping("/test/**")
    public String mark(Model model) {
        model.addAttribute("message", "Path");
        return "index";
    }
}
