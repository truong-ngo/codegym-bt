package com.example.backend.service.impl;

import com.example.backend.model.Category;
import com.example.backend.model.Product;
import com.example.backend.repository.IProductRepo;
import com.example.backend.service.core.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Value("${media}")
    private String fileUpload;
    private final IProductRepo productRepo;

    @Autowired
    public ProductService(IProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public Iterable<Product> findAllByCategory(Category category) {
        return productRepo.findAllByCategory(category);
    }

    @Override
    public Iterable<Product> findAllByPriceBetween(Double start, Double end) {
        return productRepo.findAllByPriceBetween(start, end);
    }

    @Override
    public Iterable<Product> findAllByPriceGreaterThan(Double start) {
        return productRepo.findAllByPriceGreaterThan(start);
    }

    @Override
    public Iterable<Product> findAllByNameContaining(String name) {
        return productRepo.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Product> findAllByOrderByNameAsc() {
        return productRepo.findAllByOrderByNameAsc();
    }

    @Override
    public Iterable<Product> findAllByOrderByPriceAsc() {
        return productRepo.findAllByOrderByPriceAsc();
    }

    public Product copyFile(Product product) {
        MultipartFile file = product.getImgFile();
        String image = file.getOriginalFilename();
        product.setImage(image);
        try {
            FileCopyUtils.copy(file.getBytes(), new File(fileUpload + image));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}
