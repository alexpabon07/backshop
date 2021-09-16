package com.alexpabon07.backshop.controller;

import com.alexpabon07.backshop.entities.Customer;
import com.alexpabon07.backshop.service.ICustomerService;
import com.alexpabon07.backshop.util.Constants;
import com.alexpabon07.backshop.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    private Response response;

    @GetMapping(Constants.GET_CUSTOMER)
    public Response getAllCustomers() {
        response = new Response();
        try {
            List<Customer> customerList = customerService.findAll();
            response = response.buildResponse(customerList, "Get", 200, Boolean.TRUE);
        } catch (Exception e) {
            response = response.buildResponse(null, e.getMessage(), 404, Boolean.FALSE);
        }
        return response;
    }

    @PostMapping(Constants.ADD_CUSTOMER)
    public Response addCustomer(@RequestBody Customer customer) {
        response = new Response();
        try {
            customerService.save(customer);
            response = response.buildResponse(customerService.findAll(), "Created", 201, Boolean.TRUE);
        } catch (Exception e) {
            response = response.buildResponse(null, e.getMessage(), 400, Boolean.FALSE);
        }
        return response;
    }

    @PutMapping(Constants.UPDATE_CUSTOMER)
    public Response updateCustomer(@PathVariable("id") int id) {
        response = new Response();
        try {
            customerService.findById(id);
            response = response.buildResponse(customerService.findById(id), "Updated", 204, Boolean.TRUE);
        } catch (Exception e) {
            response = response.buildResponse(null, e.getMessage(), 404, Boolean.FALSE);
        }
        return response;
    }

    @GetMapping(Constants.DELETE_CUSTOMER)
    public Response deleteCustomer(@PathVariable("id") int id) {
        response = new Response();
        try {
            customerService.delete(id);
            response = response.buildResponse(customerService.findAll(), "Deleted", 204, Boolean.TRUE);
        } catch (Exception e) {
            response = response.buildResponse(null, e.getMessage(), 404, Boolean.FALSE);
        }
        return response;
    }
}
