package com.example.email.controller;

import com.example.email.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SettingController {
    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @GetMapping("/setting")
    public ModelAndView setting() {
        return new ModelAndView("setting");
    }

    @PostMapping("/save")
    public String saveSetting(@ModelAttribute Setting setting, RedirectAttributes redirect) {
        ModelAndView modelAndView = new ModelAndView("index");
        redirect.addFlashAttribute("setting", setting);
        redirect.addFlashAttribute("message", "Update successfully");
        return "redirect:/";
    }
}
