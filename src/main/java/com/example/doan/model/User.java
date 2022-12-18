package com.example.doan.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class User {
    public  long id;
    public  String name;
    public String username;
    public  String password;
    private Collection<Role> roles = new ArrayList<>();
}
