package com.alexpabon07.backshop.service;

import com.alexpabon07.backshop.dao.ICustomerDAO;
import com.alexpabon07.backshop.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDAO customerDAO;

    @Override
    public Customer findById(int id) {
        return customerDAO.findById(id).orElseThrow(() -> new RuntimeException("No se pudo encontrar el cliente buscado"));
    }

    @Override
    public List<Customer> findAll() {
        return ((List<Customer>) customerDAO.findAll()).stream()
                .sorted(
                        (previous, current) -> (previous.getDocument().compareTo(current.getDocument()))
                ).collect(Collectors.toList());
    }

    @Override
    public Customer save(Customer customer) {
        return customerDAO.save(customer);
    }

    @Override
    public void delete(int id) {
        try {
            customerDAO.deleteById(id);
        } catch (Exception ex) {
            throw new RuntimeException("No se pudo encontrar el cliente a eliminar");
        }
    }
}
