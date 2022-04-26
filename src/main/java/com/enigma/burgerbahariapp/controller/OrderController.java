package com.enigma.burgerbahariapp.controller;

import com.enigma.burgerbahariapp.entity.transaction.Order;
import com.enigma.burgerbahariapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public Order transaction(@RequestBody Order order,
                            @RequestParam (name = "status", defaultValue = "direct") String status,
                            @RequestParam (name = "date", defaultValue = "Date.valueOf(LocalDateTime.now().toString())") Date date) {
        return orderService.transaction(order, status, date);
    }
}
