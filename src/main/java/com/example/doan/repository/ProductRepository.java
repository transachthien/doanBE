package com.example.doan.repository;

import com.example.doan.model.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
public interface ProductRepository extends MongoRepository<Product, ObjectId> {
    @Query(value = "{ $and:[{'key_word': { $in: ?0}}]}") //, {'kind' : { $regex: ?1, $options:'i'}}
//    @Query("{ 'key_word': { $in: ?0 }, 'kind': { $regex: ?1 } }")
    List<Product> findAllProduct(List<String> keyword, String category, Pageable pageable);
    void deleteEmployeeById(Integer id);
    long countProductByClusteringIsLike(String name);
    long countProductByKeywordIsInAndKind(List<String> keyword, String kind);

    Optional<Product> findEmployeeById(Integer id);
}
