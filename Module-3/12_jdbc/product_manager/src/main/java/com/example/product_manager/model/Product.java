package com.example.product_manager.model;

public class Product {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private Brand brand;

    public Product() {
    }

    public Product(String name, Double price, String description, Brand brand) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.brand = brand;
    }

    public Product(Long id, String name, Double price, String description, Brand brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
