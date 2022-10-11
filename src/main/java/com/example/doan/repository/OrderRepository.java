package com.example.doan.repository;

import com.example.doan.model.Order;
import com.example.doan.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, Integer> {
}
