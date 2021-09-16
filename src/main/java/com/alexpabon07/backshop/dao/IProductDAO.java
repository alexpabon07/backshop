package com.alexpabon07.backshop.dao;

import com.alexpabon07.backshop.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductDAO extends CrudRepository<Product, Integer> {
}
