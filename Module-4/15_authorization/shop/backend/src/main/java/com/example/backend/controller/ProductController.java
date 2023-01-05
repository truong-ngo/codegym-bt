package com.example.backend.controller;

import com.example.backend.model.Category;
import com.example.backend.model.Product;
import com.example.backend.service.core.ICategoryService;
import com.example.backend.service.core.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/products", produces = "application/json")
public class ProductController {
    private final IProductService productService;
    private final ICategoryService categoryService;

    @Autowired
    public ProductController(IProductService productService, ICategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("item")
    public ResponseEntity<Object> getAllProducts() {
        Iterable<Product> products = productService.findAll();
        Iterable<Category> categories = categoryService.findAll();
        Object[] data = new Object[]{products, categories};
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("item/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Optional<Product> product = productService.findById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Product> save(@ModelAttribute Product product) {
        product = productService.copyFile(product);
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @PostMapping(value = "/save/{id}")
    public ResponseEntity<Product> update(@ModelAttribute Product product) {
        MultipartFile file = product.getImgFile();
        if (file == null) {
            Optional<Product> original = productService.findById(product.getId());
            if (original.isPresent()) {
                product.setImage(original.get().getImage());
                return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            product = productService.copyFile(product);
            return new ResponseEntity<>(productService.save(product), HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/filter/category/{id}")
    public ResponseEntity<Iterable<Product>> filterByCategory(@PathVariable("id") Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            Iterable<Product> products = productService.findAllByCategory(category.get());
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("filter/price")
    public ResponseEntity<Iterable<Product>> filterByPrice(@RequestParam("start") String start, @RequestParam("end") String end) {
        Iterable<Product> products;
        if (end.equals("infinity")) {
            try {
                Double startValue = Double.parseDouble(start);
                products = productService.findAllByPriceGreaterThan(startValue);
                return new ResponseEntity<>(products, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            try {
                Double startValue = Double.parseDouble(start);
                Double endValue = Double.parseDouble(end);
                products = productService.findAllByPriceBetween(startValue, endValue);
                return new ResponseEntity<>(products, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }

    @GetMapping("search")
    public ResponseEntity<Iterable<Product>> searchProduct(@RequestParam("q") String value) {
        return new ResponseEntity<>(productService.findAllByNameContaining(value), HttpStatus.OK);
    }

    @GetMapping("sort")
    public ResponseEntity<Iterable<Product>> sortProduct(@RequestParam("q") String value) {
        if (value.equals("name")) {
            Iterable<Product> products = productService.findAllByOrderByNameAsc();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else if (value.equals("price")) {
            Iterable<Product> products = productService.findAllByOrderByPriceAsc();
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
