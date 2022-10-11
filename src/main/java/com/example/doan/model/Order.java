package com.example.doan.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "order")
public class Order {
    @Transient
    public static final String SEQUENCE_NAME = "order_sequence";
    @Id
    private int id;
    @Field(name = "customer_name")
    private String customerName;
    @Field(name = "address")
    private String address;
    @Field(name = "phone_number")
    private String phoneNumber;
    @Field(name = "total_amount")
    private Double totalAmount;
    @Field(name = "order_detail")
    private String orderDetail;
    @Field(name = "created_at")
    private Date createdAt;
}
