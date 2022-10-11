package com.example.doan.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Integer id;
    private String username;
    private String password;
    private String fullName;
    private String idCardNumber;
    private String idCardType;
    private String address;
    private String description;
}
