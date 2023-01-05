package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.model.News;
import com.example.blog.service.ICategoryService;
import com.example.blog.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/news")
public class NewController {
    @Value("${new_image}")
    private String fileUpload;
    private final INewService newService;
    private final ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @Autowired
    public NewController(INewService newService, ICategoryService categoryService) {
        this.newService = newService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public ModelAndView list(@PageableDefault(value = 1) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("news/index");
        Iterable<News> news = newService.findAll(pageable);
        modelAndView.addObject("news", news);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        return new ModelAndView("news/form", "newArticle", new News());
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
        News news = newService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("news/form");
        modelAndView.addObject("newArticle", news);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirect) {
        News news = newService.findById(id).get();
        File file = new File(fileUpload + news.getImage());
        file.delete();
        newService.remove(id);
        redirect.addFlashAttribute("message", "Delete successfully");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("news/view");
        Optional<News> news = newService.findById(id);
//        modelAndView.addObject("newList", news.get().getCategory().getNews());
        modelAndView.addObject("newArticle", news.get());
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView search(@PageableDefault(value = 1) Pageable pageable, @RequestParam("search") Optional<String> search) {
        ModelAndView modelAndView = new ModelAndView("news/index");
        Iterable<News> news = newService.findByTitleContaining(search.get(), pageable);
        modelAndView.addObject("news", news);
        modelAndView.addObject("search", search);
        return modelAndView;
    }

    @GetMapping("/filter")
    public ModelAndView filter(@PageableDefault(value = 1) Pageable pageable, @RequestParam("filter") Category category) {
        ModelAndView modelAndView = new ModelAndView("news/index");
        Iterable<News> news = newService.findAllByCategory(category, pageable);
        modelAndView.addObject("news", news);
        modelAndView.addObject("filter", category.getId());
        return modelAndView;
    }

    @GetMapping("/sort")
    public ModelAndView sort(@PageableDefault(value = 1) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("news/index");
        Iterable<News> news = newService.findAllByOrderByDateUploadAsc(pageable);
        modelAndView.addObject("news", news);
        modelAndView.addObject("sort", "dateUpload");
        return modelAndView;
    }
}
