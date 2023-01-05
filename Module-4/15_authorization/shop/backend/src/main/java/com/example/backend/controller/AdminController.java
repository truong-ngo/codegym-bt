package com.example.backend.controller;

import com.example.backend.model.Category;
import com.example.backend.model.Product;
import com.example.backend.model.User;
import com.example.backend.service.core.ICategoryService;
import com.example.backend.service.core.IProductService;
import com.example.backend.service.core.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/admin", produces = "application/json")
public class AdminController {
    @Value("${media}")
    private String fileUpload;
    private final IProductService productService;
    private final ICategoryService categoryService;
    private final IUserService userService;

    @Autowired
    public AdminController(IProductService productService, ICategoryService categoryService, IUserService userService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping("/items")
    public ResponseEntity<Object> dashboard() {
        Iterable<Product> products = productService.findAll();
        Iterable<Category> categories = categoryService.findAll();
        Iterable<User> users = userService.findAll();
        Object[] objects = new Object[]{products, categories, users};
        return new ResponseEntity<>(objects, HttpStatus.OK);
    }
}
