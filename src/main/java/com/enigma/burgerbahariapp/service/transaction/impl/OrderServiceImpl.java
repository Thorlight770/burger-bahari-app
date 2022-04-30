package com.enigma.burgerbahariapp.service.transaction.impl;

import com.enigma.burgerbahariapp.entity.master.Customer;
import com.enigma.burgerbahariapp.entity.master.DiningTable;
import com.enigma.burgerbahariapp.entity.transaction.Order;
import com.enigma.burgerbahariapp.entity.transaction.TableDetail;
import com.enigma.burgerbahariapp.repository.transaction.OrderRepository;
import com.enigma.burgerbahariapp.repository.transaction.TableDetailRepository;
import com.enigma.burgerbahariapp.service.master.CustomerService;
import com.enigma.burgerbahariapp.service.master.DiningTableService;
import com.enigma.burgerbahariapp.service.transaction.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    DiningTableService diningTableService;

    @Autowired
    CustomerService customerService;

    @Autowired
    TableDetailRepository tableDetailRepository;

    @Override
    @Transient
    @Transactional
    public Order transaction(Order order, String status) {
        Customer customer = customerService.getCustomerByEmail(order.getCustomer().getEmail());
        order.setCustomer(customer);

        Order order1 = orderRepository.save(order);
        LocalDateTime localDateTime = null;

        for(TableDetail tableDetail: order1.getTableDetailList()) {
            tableDetail.setOrder(order1);

            DiningTable diningTable = diningTableService.getTableByNumber(tableDetail.getDiningTable().getNumber());
            if (tableDetail.getDate()==null && localDateTime==null) {
                localDateTime = LocalDateTime.now();
            } else if (tableDetail.getDate()!=null) {
                localDateTime = tableDetail.getDate();
            }
            diningTable.setStatus(true);
            diningTableService.saveTable(diningTable);

            tableDetail.setDate(localDateTime);
            tableDetail.setDiningTable(diningTable);
            tableDetailRepository.save(tableDetail);
        }


        order1.setStatus(status);
        return orderRepository.save(order1);
    }
}
