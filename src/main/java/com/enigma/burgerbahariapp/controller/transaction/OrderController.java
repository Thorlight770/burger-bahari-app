package com.enigma.burgerbahariapp.controller.transaction;

import com.enigma.burgerbahariapp.entity.transaction.Order;
import com.enigma.burgerbahariapp.service.transaction.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public Order createTransaction(@RequestBody Order order,
                                   @RequestParam (name = "status", defaultValue = "direct") String status) {

        return orderService.transaction(order, status);
    }
}
