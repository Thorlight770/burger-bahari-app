package com.enigma.burgerbahariapp.service;

import com.enigma.burgerbahariapp.entity.transaction.Order;

import java.sql.Date;

public interface OrderService {
    Order transaction(Order order, String status, Date date);
}
