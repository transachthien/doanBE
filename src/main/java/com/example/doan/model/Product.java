package com.example.doan.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Setter
@Getter
//@Entity
@Document(collection = "product")
public class Product {
    @Transient
    public static final String SEQUENCE_NAME = "product_sequence";
    @MongoId(FieldType.OBJECT_ID)
    private String _id;
    private String name;
    private int price;
    private String img;
    private String link;
    private String text;
    @Field("key_word")
    private String keyword;
    private boolean process_text;
    private boolean process_summery;
    private String datePublish;
    private String userPost;
    private boolean Key_checking;
    private String text_summary;
    private String clustering;
    private String predict;
    private String kind;
    private int id;

}
