package com.example.doan.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {
        private String name;
        private int price;
        private String img;
        private int productID;
        private int quantity;
}
