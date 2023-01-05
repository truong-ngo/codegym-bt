package com.example.product.controller;

import com.example.product.model.Brand;
import com.example.product.model.Product;
import com.example.product.service.core.IBrandService;
import com.example.product.service.core.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;
    private final IBrandService brandService;

    @Autowired
    public ProductController(IProductService productService, IBrandService brandService) {
        this.productService = productService;
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity<Object[]> list() {
        Object[] objects = new Object[]{productService.findAll(), brandService.findAll()};
        return new ResponseEntity<>(objects, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getCustomer(@PathVariable Long id) {
        Optional<Product> customer = productService.findById(id);
        return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        Optional<Product> customer = productService.findById(id);
        if (customer.isPresent()) {
            productService.remove(id);
            return new ResponseEntity<>(customer.get(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
