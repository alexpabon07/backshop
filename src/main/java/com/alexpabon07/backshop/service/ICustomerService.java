package com.alexpabon07.backshop.service;

import com.alexpabon07.backshop.entities.Customer;

import java.util.List;

public interface ICustomerService {

    Customer findById(int id);
    List<Customer> findAll();
    Customer save(Customer customer);
    void delete(int id);
}
