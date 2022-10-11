package com.example.doan.controller;

import com.example.doan.model.Order;
import com.example.doan.repository.OrderRepository;
import com.example.doan.service.SequenceGeneratorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.doan.model.Order.SEQUENCE_NAME;


public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @PostMapping
    public String save(Order order){
        order.setId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
        orderRepository.save(order);
        return "ok";
    }

}
