package com.example.view_count.controller;

import com.example.view_count.model.Counter;


import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
//@SessionAttributes("counter")
public class CounterController {
    @ModelAttribute("counter")
    public Counter setUpCounter() {
        return new Counter();
    }

    @GetMapping
    public String get(HttpServletRequest request) {
        Counter counter = new Counter();
        HttpSession session = request.getSession();
        session.setAttribute("counter", counter);
        return "index";
    }

    @GetMapping("/increase")
    public String increase(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Counter counter = (Counter) session.getAttribute("counter");
        counter.increment();
        return "index";
    }

    @GetMapping("/end")
    public String setTimeOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "index";
    }
}
