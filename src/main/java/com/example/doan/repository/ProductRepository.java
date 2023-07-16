package com.example.doan.repository;

import com.example.doan.model.Product;
import org.bson.types.Code;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface ProductRepository extends MongoRepository<Product, Integer> {
    @Query("{'name': { $regex: ?0,$options:'i'}, 'category' : { $regex: ?1, $options:'i'}}")
    List<Product> findAllProduct(String name, String category, Pageable pageable);
    void deleteEmployeeById(Integer id);

    Optional<Product> findEmployeeById(Integer id);
}
