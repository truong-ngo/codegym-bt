package com.example.upload_demo.controller;

import com.example.upload_demo.model.Upload;
import com.example.upload_demo.service.UploadService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class DemoController {
    @GetMapping("/demo")
    public ModelAndView demo() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("upload", new Upload());
        return modelAndView;
    }

    @PostMapping("/upload")
    public ModelAndView upload(Upload upload) throws IOException {
        ModelAndView modelAndView = new ModelAndView("view");
        UploadService uploadService = new UploadService();
        uploadService.uploadFile(upload.getFile());
        return modelAndView;
    }
}
