package com.example.path_variables_and_request_parameters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VariableController {

    @GetMapping("/id/{id}/name/{name}")
    public String find(@PathVariable Long id, @PathVariable String name) {
        return "index";
    }

    @GetMapping("/{name:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{ext:\\.[a-z]+}")
    public String regex(@PathVariable String name, @PathVariable String version, @PathVariable String ext) {
        return "index";
    }

}
