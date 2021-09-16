package com.alexpabon07.backshop.service;

import com.alexpabon07.backshop.entities.Product;

import java.util.List;

public interface IProductService {

    Product findById(int id);
    List<Product> findAll();
    Product save(Product product);
    void delete(int id);
}
