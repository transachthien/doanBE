package com.example.doan.repository;
import com.example.doan.model.User;

import java.util.List;
//extends JpaRepository<User, Long>
public interface UserRepo {
    User findByUsername(final String username);

    List<User> findAll();
}
