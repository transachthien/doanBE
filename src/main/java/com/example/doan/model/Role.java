package com.example.doan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document(collection = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @MongoId(FieldType.OBJECT_ID)
    public String id;
    public String name;
    public Role(String name){
        this.name = name;
    }
}
