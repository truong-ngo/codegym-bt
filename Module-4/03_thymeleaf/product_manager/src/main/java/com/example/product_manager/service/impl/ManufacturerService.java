package com.example.product_manager.service.impl;

import com.example.product_manager.model.Manufacturer;
import com.example.product_manager.service.IManufacturerService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ManufacturerService implements IManufacturerService {
    private static ManufacturerService instance;
    private static final Map<Long, Manufacturer> manufacturers;

    static {
        manufacturers = new TreeMap<>();
        manufacturers.put(1L, new Manufacturer(1L, "Google"));
        manufacturers.put(2L, new Manufacturer(2L, "Samsung"));
        manufacturers.put(3L, new Manufacturer(3L, "Apple"));
    }

    private ManufacturerService() {
    }

    public static ManufacturerService getInstance() {
        if (instance == null) {
            instance = new ManufacturerService();
        }
        return instance;
    }

    @Override
    public List<Manufacturer> findAll() {
        return new ArrayList<>(manufacturers.values());
    }

    @Override
    public Manufacturer findById(Long id) {
        return manufacturers.get(id);
    }

    @Override
    public void insert(Manufacturer manufacturer) {
        manufacturers.put(manufacturer.getId(), manufacturer);
    }

    @Override
    public void update(Long id, Manufacturer manufacturer) {
        manufacturers.put(id, manufacturer);
    }

    @Override
    public void delete(Long id) {
        manufacturers.remove(id);
    }

    @Override
    public List<Manufacturer> findByName(String name) {
        List<Manufacturer> result = new ArrayList<>();
        for (Manufacturer manufacturer : findAll()) {
            if (manufacturer.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(manufacturer);
            }
        }
        return result;
    }
}
