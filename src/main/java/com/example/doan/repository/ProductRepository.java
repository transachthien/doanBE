package com.example.doan.repository;

import com.example.doan.model.Product;
import org.bson.types.Code;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Integer> {
}
