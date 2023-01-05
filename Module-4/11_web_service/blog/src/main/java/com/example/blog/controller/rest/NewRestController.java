package com.example.blog.controller.rest;

import com.example.blog.model.Category;
import com.example.blog.model.News;
import com.example.blog.service.ICategoryService;
import com.example.blog.service.INewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/new")
public class NewRestController {
    private final INewService newService;
    private final ICategoryService categoryService;

    public NewRestController(INewService newService, ICategoryService categoryService) {
        this.newService = newService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<Iterable<News>> findAll() {
        List<News> newsList = (List<News>) newService.findAll();
        if (newsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<News> saveCustomer(@RequestBody News news) {
        return new ResponseEntity<>(newService.save(news), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<News> updateCustomer(@PathVariable Long id, @RequestBody News news) {
        Optional<News> customerOptional = newService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        news.setId(customerOptional.get().getId());
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
        if (!newsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(newsOptional.get(), HttpStatus.OK);
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
}
