package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.model.News;
import com.example.blog.service.ICategoryService;
import com.example.blog.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final ICategoryService categoryService;
    private final INewService newService;

    @Autowired
    public CategoryController(ICategoryService categoryService, INewService newService) {
        this.categoryService = categoryService;
        this.newService = newService;
    }

    @GetMapping
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("categories/index");
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("categories/form");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("category") Category category, RedirectAttributes redirect) {
        String message = (category.getId() != null) ? "Updated successfully" : "Created successfully";
        categoryService.save(category);
        redirect.addFlashAttribute("message", message);
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        Optional<Category> category = categoryService.findById(id);
        ModelAndView modelAndView;
        if (category.isPresent()) {
            modelAndView = new ModelAndView("categories/form");
            modelAndView.addObject("category", category.get());
        } else {
            modelAndView = new ModelAndView("error404");
        }
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirect) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            categoryService.remove(id);
            redirect.addFlashAttribute("message", "Deleted successfully");
        } else {
            redirect.addFlashAttribute("message", "Some thing went wrong");
        }
        return "redirect:/category";
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        Optional<Category> category = categoryService.findById(id);
        if(!category.isPresent()){
            return new ModelAndView("error404");
        }
        Iterable<News> news = newService.findAllByCategory(category.get());
        ModelAndView modelAndView = new ModelAndView("categories/view");
        modelAndView.addObject("category", category.get());
        modelAndView.addObject("news", news);
        return modelAndView;
    }
}
