package com.example.doan.repository;

import com.example.doan.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepo extends MongoRepository<Role, String> {
    Role findByName(String name);

}
