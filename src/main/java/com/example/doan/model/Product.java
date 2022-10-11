package com.example.doan.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
//@Entity
@Document(collection = "product")
public class Product {
    @Transient
    public static final String SEQUENCE_NAME = "product_sequence";
    @Id
    private int id;
    private String name;
    private int price;
    private String img;
}
