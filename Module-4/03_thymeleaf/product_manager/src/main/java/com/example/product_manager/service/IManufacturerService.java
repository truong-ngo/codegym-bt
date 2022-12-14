package com.example.product_manager.service;

import com.example.product_manager.model.Manufacturer;

import java.util.List;

public interface IManufacturerService extends IService<Manufacturer, Long> {
    List<Manufacturer> findByName(String name);
}
