package com.example.doan.controller;

import com.example.doan.model.FormSeachListNew;
import com.example.doan.model.FormSearch;
import com.example.doan.model.Product;
import com.example.doan.model.ResponseKeyWord;
import com.example.doan.repository.ProductCustomRepository;
import com.example.doan.repository.ProductRepository;
import com.example.doan.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "/api/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCustomRepository productCustomRepository;

    @PostMapping("/getAllProduct")
    public List<Product> getAllProduct(@RequestParam(defaultValue ="", required = false) String[] name ,
                                       @RequestParam(defaultValue ="", required = false) String category,
                                       @RequestBody FormSearch formSearch,
                                       @RequestParam(defaultValue ="1", required = false) int page){
        Pageable paging = PageRequest.of(page, 6);
        List<String> keyword = new ArrayList<>();
//        String predict ="";
        if(formSearch.getName().length>0){
            for(var key: formSearch.getName()){
                keyword.add(productService.convertStringToId(key));
            }
        }
//        if(formSearch.getKindCluster().equals("0")){
//
//        }else if(formSearch.getKindCluster().equals("1")){
//            predict = "POS";
//
//        }else if(formSearch.getKindCluster().equals("2")){
//            predict = "NEG";
//        }
        List<String> predict = new ArrayList<>();
        if(formSearch.getKindCluster().equals("0")){
            predict.add("POS");
            predict.add("NEG");

        }else if(formSearch.getKindCluster().equals("1")){
            predict.add("POS");
//            predict = "POS";

        }else if(formSearch.getKindCluster().equals("2")){
            predict.add("NEG");
//            predict = "NEG";
        }
         return productRepository.findAllProduct(keyword, formSearch.getCategory(),predict, paging);
    }
//    @GetMapping("/getProductDetail")
//    public Optional<Product> getProductDetail(@RequestParam int id){
//        return  productRepository.findById(id);
//    }
    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product newEmployee = new Product();
//                productService.addProduct(product);
        return new ResponseEntity<>(newEmployee, HttpStatus.OK);
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
    @PostMapping("/find")
    public ResponseEntity<Long> getProduct(@RequestBody FormSearch formSearch) {
        List<String> keyword = new ArrayList<>();
        if(formSearch.getName().length>0){
            for(var key: formSearch.getName()){
                keyword.add(productService.convertStringToId(key));
            }
        }
//        List<String> predict = new ArrayList<>();
        String predict ="";
        if(formSearch.getKindCluster().equals("0")){
//            predict.add("POS");
//            predict.add("NEG");

        }else if(formSearch.getKindCluster().equals("1")){
//            predict.add("POS");
            predict = "POS";

        }else if(formSearch.getKindCluster().equals("2")){
//            predict.add("NEG");
            predict = "NEG";
        }
//        var count = productRepository.countProductByKeywordIsInAndKindAndAndPredictIsIn(keyword, formSearch.getCategory(), predict);
        var count = productCustomRepository.findByCustomQuery(keyword, formSearch.getCategory(), predict);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
    @PostMapping("/findTotalNewInKeyWord")
    public ResponseEntity<List<ResponseKeyWord>> findTotalNewInKeyWord(@RequestBody FormSearch formSearch) {
        List<String> keyword = new ArrayList<>();
        if(formSearch.getName().length>0){
            for(var key: formSearch.getName()){
                keyword.add(productService.convertStringToId(key));
            }
        }
        var count = productService.finAllCountKeyWord(keyword, formSearch.getCategory());
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
    @GetMapping("/findTotalNewInCluster")
    public ResponseEntity<List<ResponseKeyWord>> findTotalNewInCluster() {
        var count = productService.finAllCountCluster();
        return new ResponseEntity<>(count, HttpStatus.OK);
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
    @PostMapping("/findListNewSave")
    public ResponseEntity<List<Product>> getProduct(@RequestBody FormSeachListNew formSearch) {
//        List<String> keyword = new ArrayList<>();
//        if(formSearch.getName().length>0){
//            for(var key: formSearch.getName()){
//                keyword.add(productService.convertStringToId(key));
//            }
//        }
        var count = productService.findAllProductSave(formSearch.getName());
        return new ResponseEntity<>(count, HttpStatus.OK);
    }



}
