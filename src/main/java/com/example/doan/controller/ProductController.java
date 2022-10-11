package com.example.doan.controller;

import com.example.doan.model.Product;
import com.example.doan.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping(value = "/api/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/getAllProduct")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    @GetMapping("/getProductDetail")
    public Optional<Product> getProductDetail(@RequestParam int id){
        return  productRepository.findById(id);
    }



}
