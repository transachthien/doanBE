package com.example.doan.service;

import com.example.doan.model.CartDetail;
import com.example.doan.model.CartItem;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class CartService {
    public CartDetail caculateCart(CartDetail cartDetail){
         Double total = 0.0;
         if(cartDetail.getCartItems().size()>0){
//             cartDetail.getCartItems().stream().forEach(cartItem ->
//             {
//                 total.updateAndGet(v -> v + cartItem.getPrice() * cartItem.getQuantity());});

             for(CartItem x :cartDetail.getCartItems()){
                 total+= Double.valueOf(x.getPrice()*x.getQuantity());
             }
         }
        cartDetail.setTotalAmount(total);
         return cartDetail;
    }
}
