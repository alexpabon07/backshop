package com.alexpabon07.backshop.controller;

import com.alexpabon07.backshop.entities.Product;
import com.alexpabon07.backshop.service.IProductService;
import com.alexpabon07.backshop.util.Constants;
import com.alexpabon07.backshop.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private IProductService productService;
    private Response response;

    @GetMapping(Constants.GET_PRODUCT)
    public Response getAllProducts() {
        response = new Response();
        try {
            List<Product> productList = productService.findAll();
            response = response.buildResponse(productList, "Get", 200, Boolean.TRUE);
        } catch (Exception e) {
            response = response.buildResponse(null, e.getMessage(), 404, Boolean.FALSE);
        }
        return response;
    }

    @PostMapping(Constants.ADD_PRODUCT)
    public Response addProduct(@RequestBody Product product) {
        response = new Response();
        try {
            productService.save(product);
            response = response.buildResponse(productService.findAll(), "Created", 201, Boolean.TRUE);
        } catch (Exception e) {
            response = response.buildResponse(null, e.getMessage(), 400, Boolean.FALSE);
        }
        return response;
    }

    @PutMapping(Constants.UPDATE_PRODUCT)
    public Response updateProduct(@PathVariable("id") int id) {
        response = new Response();
        try {
            productService.findById(id);
            response = response.buildResponse(productService.findAll(), "Updated", 204, Boolean.TRUE);
        } catch (Exception e) {
            response = response.buildResponse(null, e.getMessage(), 404, Boolean.FALSE);
        }
        return response;
    }

    @GetMapping(Constants.DELETE_PRODUCT)
    public Response deleteProduct(@PathVariable("id") int id) {
        response = new Response();
        try {
            productService.delete(id);
            response = response.buildResponse(productService.findAll(), "Deleted", 204, Boolean.TRUE);
        } catch (Exception e) {
            response = response.buildResponse(null, e.getMessage(), 404, Boolean.FALSE);
        }
        return response;
    }
}
