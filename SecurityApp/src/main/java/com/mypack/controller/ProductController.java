package com.mypack.controller;

import com.mypack.DTO.Product;
import com.mypack.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    ProductService service;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to security app to all";
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return service.getProductList();
    }

    @GetMapping("/{id}")
    public Product getproductById(@PathVariable int id){
        return service.getProductById(id);
    }
}
