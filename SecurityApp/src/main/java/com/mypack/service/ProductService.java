package com.mypack.service;

import com.mypack.DTO.Product;
import com.mypack.entity.UserInfo;
import com.mypack.repository.UserInfoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    @Autowired
    UserInfoRepository repository;

    @Autowired
    PasswordEncoder encoder;

    List<Product> list;

    @PostConstruct
    public void loadProducts(){
        list=IntStream.rangeClosed(1,100)
                .mapToObj(i-> Product.builder().id(i)
                        .name("product: "+i)
                        .qty(new Random().nextInt(100))
                        .price(new Random().nextInt(10000))
                        .build())
                .collect(Collectors.toList());
    }

    public List<Product> getProductList(){
        return list;
    }

    public Product getProductById(int id){
        return  list.stream().filter(product -> product.getId()==id)
                .findAny()
                .orElseThrow(()-> new RuntimeException("product not found with id: "+id));
    }

    public String addUser(UserInfo userInfo){
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added successfully...";
    }
}
