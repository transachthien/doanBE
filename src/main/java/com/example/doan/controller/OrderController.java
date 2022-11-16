package com.example.doan.controller;

import com.example.doan.model.Order;
import com.example.doan.repository.OrderRepository;
import com.example.doan.service.RSAUtil;
import com.example.doan.service.SequenceGeneratorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;

import static com.example.doan.model.Order.SEQUENCE_NAME;

@Log4j2
@RestController
@RequestMapping(value = "/api/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    private RSAUtil rsaUtil;
    @PostMapping
    public String save(@RequestBody Order order) throws InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException{
        order.setId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
        order.setAddress(rsaUtil.decrypt(order.getAddress(),rsaUtil.getPrivateKey()));
        order.setPhoneNumber(rsaUtil.decrypt(order.getPhoneNumber(),rsaUtil.getPrivateKey()));
        order.setEmail(rsaUtil.decrypt(order.getEmail(),rsaUtil.getPrivateKey()));
        order.setCardNumber(rsaUtil.decrypt(order.getCardNumber(),rsaUtil.getPrivateKey()));
        orderRepository.save(order);
        return "ok";
    }

}
