package com.example.doan.service;
import com.example.doan.model.Role;
import com.example.doan.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    User saveUser(User user);
    User updateUser(User user);
    Role saveRole(Role role);
    void addRoleUSer(String username, String roleName);
    User getUsers(String username);
    List<User> getUsers();
}
