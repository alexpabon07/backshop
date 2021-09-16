package com.alexpabon07.backshop.service;

import com.alexpabon07.backshop.dao.IProductDAO;
import com.alexpabon07.backshop.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDAO productDAO;

    @Override
    public Product findById(int id) {
        return productDAO.findById(id).orElseThrow(() -> new RuntimeException("No se pudo encontrar el producto buscado"));
    }

    @Override
    public List<Product> findAll() {
        return ((List<Product>) productDAO.findAll()).stream()
                .sorted(
                        (previous, current) -> (previous.getName().compareTo(current.getName()))
                ).collect(Collectors.toList());
    }

    @Override
    public Product save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public void delete(int id) {
        try {
            productDAO.deleteById(id);
        } catch (Exception ex) {
            throw new RuntimeException("No se pudo encontrar el producto a eliminar");
        }
    }
}
