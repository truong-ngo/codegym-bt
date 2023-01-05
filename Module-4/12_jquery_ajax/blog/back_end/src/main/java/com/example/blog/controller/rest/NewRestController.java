package com.example.blog.controller.rest;

import com.example.blog.model.Category;
import com.example.blog.model.News;
import com.example.blog.service.ICategoryService;
import com.example.blog.service.INewService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/new")
public class NewRestController {
    private final INewService newService;
    private final ICategoryService categoryService;

    public NewRestController(INewService newService, ICategoryService categoryService) {
        this.newService = newService;
        this.categoryService = categoryService;
    }

//    @GetMapping
//    public ResponseEntity<Object> findAll() {
//        Iterable<News> newsList = newService.findAll();
//        Iterable<Category> categories = categoryService.findAll();
//        return new ResponseEntity<>(new Object[]{newsList, categories}, HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<Object> list(@PageableDefault(value = 1) Pageable pageable) {
        Iterable<News> news = newService.findAll(pageable);
        Iterable<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(new Object[]{news, categories}, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<News> saveCustomer(@RequestBody News news) {
        LocalDate dateUpload = LocalDate.now();
        news.setDateUpload(dateUpload);
        return new ResponseEntity<>(newService.save(news), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<News> updateCustomer(@PathVariable Long id, @RequestBody News news) {
        Optional<News> optionalNews = newService.findById(id);
        if (!optionalNews.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        news.setId(optionalNews.get().getId());
        news.setDateUpload(optionalNews.get().getDateUpload());
        return new ResponseEntity<>(newService.save(news), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<News> deleteCustomer(@PathVariable Long id) {
        Optional<News> newsOptional = newService.findById(id);
        if (!newsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        newService.remove(id);
        return new ResponseEntity<>(newsOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> findById(@PathVariable Long id) {
        Optional<News> newsOptional = newService.findById(id);
        return newsOptional.map(news -> new ResponseEntity<>(news, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("category/{id}")
    public ResponseEntity<Iterable<News>> findByCategory(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (!category.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<News> newsList = (List<News>) newService.findAllByCategory(category.get());
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<News>> search(@RequestParam("search") Optional<String> search) {
        Iterable<News> news = newService.findByTitleContaining(search.get());
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
}
