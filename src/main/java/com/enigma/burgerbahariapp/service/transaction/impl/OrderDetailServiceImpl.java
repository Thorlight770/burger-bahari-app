package com.enigma.burgerbahariapp.service.transaction.impl;

import com.enigma.burgerbahariapp.entity.transaction.OrderDetail;
import com.enigma.burgerbahariapp.repository.transaction.OrderDetailRepository;
import com.enigma.burgerbahariapp.service.transaction.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Override
    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }
}
