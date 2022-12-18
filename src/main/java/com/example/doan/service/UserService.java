package com.example.doan.service;
import com.example.doan.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    User getUsers(String username);
    List<User> getUsers();
}
