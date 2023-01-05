package com.example.cart_complete.controller;

import com.example.cart_complete.model.Cart;
import com.example.cart_complete.model.User;
import com.example.cart_complete.service.core.ICartService;
import com.example.cart_complete.service.core.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    private final IUserService userService;
    private final ICartService cartService;

    @Autowired
    public UserController(IUserService userService, ICartService cartService) {
        this.userService = userService;
        this.cartService = cartService;
    }

    @GetMapping
    public ModelAndView form() {
        return new ModelAndView("user/form");
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model, RedirectAttributes redirect, HttpServletRequest request) {
        User check = userService.findByUsername(user.getUsername());
        if (check == null) {
            userService.save(user);
            cartService.save(new Cart(user));
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            redirect.addFlashAttribute("message", "Register successfully");
            return "redirect:/product";
        } else {
            model.addAttribute("message", "Username already exist");
            return "user/form";
        }
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model, RedirectAttributes redirect, HttpServletRequest request) {
        User check = userService.findByUsername(user.getUsername());
        if (check != null && check.getPassword().equals(user.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("user", check);
            redirect.addFlashAttribute("message", "Register successfully");
            return "redirect:/product";
        } else {
            model.addAttribute("message", "Wrong username or password");
            return "user/form";
        }
    }

    @GetMapping("/logout")
    public String logout(RedirectAttributes redirect, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/product";
    }
}