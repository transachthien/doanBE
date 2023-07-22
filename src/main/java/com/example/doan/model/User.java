package com.example.doan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @MongoId(FieldType.OBJECT_ID)
    public  String id;
    public  String name;
    public String username;
    public  String password;
    private List<Role> roles;
    public List<String> listKeyWord;
    public List<String> listNewSave;



}
