package com.example.doan.service;
import com.example.doan.model.User;
import com.example.doan.repository.UserRepo;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
@Slf4j
@NoArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService{
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

//    public RoleRepo roleRepo;
//    @Override
//    public User saveUser(User user) {
//        log.info("Saving new user in database");
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepo.save(user);
//    }
//
//    @Override
//    public Role saveRole(Role role) {
//        log.info("Saving new role {} in database",role.getName());
//        return roleRepo.save(role);
//    }

//    @Override
//    public void addRoleUSer(String username, String roleName) {
//        log.info("Adding new role {} to user {}",roleName,username);
//        User user = userRepo.findByUsername(username);
//        Role role = roleRepo.findByName(roleName);
//        user.getRoles().add(role);
//
//    }

    @Override
    public User getUsers(String username) {
        log.info("Fetching user {}",username);
        return userRepo.findByUsername(username);
    }

    //findBy giống tên thuộc tính rất nhậy với mấy cái impelemnt trong hàm

    @Override
    public List<User> getUsers() {
        log.info("Fetching all user");
        return userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user == null){
            log.error("user not found");
            throw new UsernameNotFoundException("user not found");
        } else {
            log.info("user found: {}",username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}
