package com.example.doan.repository;
import com.example.doan.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class ProductCustomRepository {
    private final MongoTemplate mongoTemplate;
    public long findByCustomQuery(List<String> keywords, String categoryRegex, String predict) {
        // Your native MongoDB query
//        String query = "{$and: [{'key_word': {$in: ?0}}, {'category': {$regex: ?1, $options: 'i'}}]}";
        Criteria criteria = new Criteria()
                .andOperator(
                        Criteria.where("key_word").in(keywords),
                        Criteria.where("kind").regex(categoryRegex, "i")
//                        , Criteria.where("predict").regex(predict, "i")
                );

        // Create the Query with the given Criteria
        Query query = new Query(criteria);

        return mongoTemplate.count(query, Product.class);
    }
}
