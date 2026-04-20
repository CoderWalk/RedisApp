package com.mypack.service;

import com.mypack.DTO.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

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
}
