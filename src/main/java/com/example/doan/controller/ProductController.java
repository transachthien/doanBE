package com.example.doan.controller;

import com.example.doan.model.Product;
import com.example.doan.repository.ProductRepository;
import com.example.doan.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping(value = "/api/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProduct")
    public List<Product> getAllProduct(@RequestParam(defaultValue ="", required = false) String name ,
                                       @RequestParam(defaultValue ="", required = false) String category){
        return productRepository.findAllProduct(name, category);
    }
    @GetMapping("/getProductDetail")
    public Optional<Product> getProductDetail(@RequestParam int id){
        return  productRepository.findById(id);
    }
    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product newEmployee = productService.addProduct(product);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> employees = productService.findAllProduct();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id) {
        Product newEmployee = productService.findProduct(id);
        return new ResponseEntity<>(newEmployee, HttpStatus.OK);
    }
//    @PostMapping("/add")
//    public ResponseEntity<Product> addEmployee(@RequestBody Product product){
//        Product newEmployee = productService.addProduct(product);
//        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
//    }
    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product updateEmployee = productService.updateProduct(product);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
