package com.example.doan.controller;

import com.example.doan.model.CartDetail;
import com.example.doan.service.CartService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping(value = "api/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @PostMapping("/caculate")
    public CartDetail caculatePrice(@RequestBody CartDetail cartDetail){
        return cartService.caculateCart(cartDetail);
    }
}
