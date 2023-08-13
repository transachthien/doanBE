package com.example.doan.repository;

import com.example.doan.model.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
public interface ProductRepository extends MongoRepository<Product, ObjectId>{
//    @Query(value = "{ $and:[{'key_word': { $in: ?0}},{'kind' : { $regex: ?1, $options:'i'}},{'predict' : { $regex: ?2, $options:'i'}}]}") //, {'kind' : { $regex: ?1, $options:'i'}}
//    List<Product> findAllProduct(List<String> keyword, String category,String predict, Pageable pageable);
//    @Query("{ 'key_word': { $in: ?0 }, 'kind': { $regex: ?1 } }")
    @Query(value = "{ $and:[{'key_word': { $in: ?0}},{'kind' : { $regex: ?1, $options:'i'}},{'predict' : { $in: ?2}}]}")
    List<Product> findAllProduct(List<String> keyword, String category,List<String> predict, Pageable pageable);
    void deleteEmployeeById(Integer id);
    long countProductByClusteringIsLike(String name);
//    @Query(value = "{ $and:[{'key_word': { $in: ?0}},{'kind' : { $regex: ?1, $options:'i'}},{'predict' : { $regex: ?2, $options:'i'}}]}")
    long countProductByKeywordIsInAndKindAndAndPredictIsIn(List<String> keyword, String kind, List<String> predict);
//    @Query(value = "{ $and:[{'_id': { $in: ?0}}]}")
    List<Product> findByIdIn(List<ObjectId> ids);

    Optional<Product> findEmployeeById(Integer id);
}
