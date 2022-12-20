package com.example.blog.controller;

import com.example.blog.model.News;
import com.example.blog.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

@Controller
@RequestMapping
public class NewController {
    @Value("${new_image}")
    private String fileUpload;
    private final INewService newService;

    @Autowired
    public NewController(INewService newService) {
        this.newService = newService;
    }

    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("news", newService.findAll());
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        return new ModelAndView("form", "newArticle", new News());
    }

    @PostMapping("/save")
    public String add(@ModelAttribute("new") News news, @RequestParam(value = "image_file", required = false) MultipartFile image, RedirectAttributes redirect) {
        LocalDate date = LocalDate.now();
        news.setDateUpload(date);
        String fileName = image.getOriginalFilename();
        news.setImage(fileName);
        try {
            FileCopyUtils.copy(image.getBytes(), new File(fileUpload + fileName));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        newService.save(news);
        redirect.addFlashAttribute("message", "Add successfully");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        News news = newService.findById(id);
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("newArticle", news);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirect) {
        News news = newService.findById(id);
        File file = new File(fileUpload + news.getImage());
        file.delete();
        newService.remove(id);
        redirect.addFlashAttribute("message", "Delete successfully");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable("id") Long id) {
        News news = newService.findById(id);
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("newArticle", news);
        return modelAndView;
    }
}
