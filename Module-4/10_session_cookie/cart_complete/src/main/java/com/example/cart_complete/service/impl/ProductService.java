package com.example.cart_complete.service.impl;

import com.example.cart_complete.model.Product;
import com.example.cart_complete.repository.IProductRepository;
import com.example.cart_complete.service.core.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Value("${file_upload}")
    private String fileUpload;

    private final IProductRepository productRepository;

    @Autowired
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public String copyImage(Product product) {
        MultipartFile file = product.getImageFile();
        String fileName = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(fileUpload + fileName));
            product.setImage(fileName);
        } catch (IOException exception) {
            fileName = "404";
        }
        return fileName;
    }

    @Override
    public String generateCode() {
        StringBuilder rand = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            rand.append((int) (Math.random() * 10));
        }
        return rand.toString();
    }
}
