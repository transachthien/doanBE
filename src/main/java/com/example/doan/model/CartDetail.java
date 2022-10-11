package com.example.doan.model;

import lombok.Data;

import java.util.List;
@Data
public class CartDetail {
    private Double totalAmount;
    private List<CartItem> cartItems;
}
