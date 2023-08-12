package com.example.doan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @MongoId(FieldType.OBJECT_ID)
    public  String id;
    public  String name;
    @Field("username")
    public String username;
    @Field("password")
    public  String password;
    @Field("roles")
    private List<Role> roles;
    @Field("listKeyWord")
    public List<String> listKeyWord;
    @Field("listNewSave")
    public List<String> listNewSave;



}
