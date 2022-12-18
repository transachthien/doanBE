package com.example.doan.service;

import com.example.doan.model.Product;
import com.example.doan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.doan.model.Product.SEQUENCE_NAME;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    private SequenceGeneratorService service;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product addProduct(Product product){
        product.setId(service.getSequenceNumber(SEQUENCE_NAME));

        return productRepository.save(product);
    }
    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }
    public Product updateProduct(Product employee){
        return productRepository.save(employee);
    }
    public Product findProduct(Integer id){
        return productRepository.findEmployeeById(id).orElseThrow(()->new ProductNotFoundException("Product by id "+id+"was not found"));
    }
    @Transactional
    public void deleteProduct(Integer id){
        productRepository.deleteEmployeeById(id);
    }
}
