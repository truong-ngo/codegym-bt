package com.example.demo_controller.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {


    @RequestMapping(value = "/produce", produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        return "Hello World";
    }

    @RequestMapping(value = "/consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String greet() {
        return "Greeting";
    }
}
