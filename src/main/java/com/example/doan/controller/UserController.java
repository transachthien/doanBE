package com.example.doan.controller;

import com.example.doan.model.Role;
import com.example.doan.model.User;
import com.example.doan.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.net.URI;

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

    @PostMapping("/user/save")
    public ResponseEntity<User>saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/save").toUriString());

        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
    @PostMapping  ("/role/save")
    public ResponseEntity<Role>saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }
    @PostMapping  ("/role/addToUser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserFrom form){
        userService.addRoleUSer(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
    @PostMapping("/user/update")
    public ResponseEntity<?>updateUser(@RequestBody User user){
        User getUser = userService.getUsers(user.username);
        getUser.setListKeyWord(user.getListKeyWord());
        getUser.setListNewSave(user.getListNewSave());
        userService.updateUser(getUser);
        return ResponseEntity.ok().body(getUser);
    }
    @GetMapping ("/user/get")
    public ResponseEntity<User> getUserByUsername(@RequestParam("username") String username){
        User getUser = userService.getUsers(username);
        return ResponseEntity.ok().body(getUser);
    }

        }
@Data
class RoleToUserFrom{
    private String username;
    private String roleName;
}
