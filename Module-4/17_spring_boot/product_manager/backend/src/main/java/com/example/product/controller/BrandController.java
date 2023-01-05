package com.example.product.controller;

import com.example.product.model.Brand;
import com.example.product.service.core.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/brands")
public class BrandController {
    private final IBrandService brandService;

    @Autowired
    public BrandController(IBrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Brand>> list() {
        return new ResponseEntity<>(brandService.findAll(), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getCustomer(@PathVariable Long id) {
        Optional<Brand> customer = brandService.findById(id);
        return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Brand> create(@RequestBody Brand brand) {
        return new ResponseEntity<>(brandService.save(brand), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Brand> update(@RequestBody Brand brand) {
        return new ResponseEntity<>(brandService.save(brand), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Brand> delete(@PathVariable Long id) {
        Optional<Brand> brand = brandService.findById(id);
        if (brand.isPresent()) {
            brandService.remove(id);
            return new ResponseEntity<>(brand.get(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
