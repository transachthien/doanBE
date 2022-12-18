package com.example.doan.controller;

import com.example.doan.model.User;
import com.example.doan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping ("/MemberTest")
    public ResponseEntity<List<User>>getUser(){

        return ResponseEntity.ok().body(userService.getUsers());
    }
    @GetMapping ("/AdminTest")
    public ResponseEntity<List<User>> getUserqq(){
        return ResponseEntity.ok().body(userService.getUsers());
    }
//    @PostMapping  ("/user/save")
//    public ResponseEntity<User>saveUser(@RequestBody User user){
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
//
//        return ResponseEntity.created(uri).body(userService.saveUser(user));
//    }
//    @PostMapping  ("/role/save")
//    public ResponseEntity<Role>saveRole(@RequestBody Role role){
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
//        return ResponseEntity.created(uri).body(userService.saveRole(role));
//    }
//    @PostMapping  ("/role/addToUser")
//    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserFrom form){
//        userService.addRoleUSer(form.getUsername(), form.getRoleName());
//        return ResponseEntity.ok().build();
//    }

}
