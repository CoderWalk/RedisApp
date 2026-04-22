package com.mypack.controller;

import com.mypack.DTO.Product;
import com.mypack.entity.UserInfo;
import com.mypack.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    //@PreAuthorize("hasRole('ADMIN')")
    public List<Product> getAllProducts(){
        return service.getProductList();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    //@PreAuthorize("hasAnyRole('USER','ADMIN')")
    public Product getProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @PostMapping("/save")
    public String addUser(@RequestBody UserInfo userInfo){
        return service.addUser(userInfo);
    }
}
