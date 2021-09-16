package com.alexpabon07.backshop.dao;

import com.alexpabon07.backshop.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerDAO extends CrudRepository<Customer, Integer> {
}
