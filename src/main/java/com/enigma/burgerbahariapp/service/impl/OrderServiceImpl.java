package com.enigma.burgerbahariapp.service.impl;

import com.enigma.burgerbahariapp.entity.master.Customer;
import com.enigma.burgerbahariapp.entity.master.DiningTable;
import com.enigma.burgerbahariapp.entity.transaction.Order;
import com.enigma.burgerbahariapp.entity.transaction.TableDetail;
import com.enigma.burgerbahariapp.repository.OrderRepository;
import com.enigma.burgerbahariapp.service.CustomerService;
import com.enigma.burgerbahariapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    DiningTableService diningTableService;

    @Autowired
    CustomerService customerService;

    @Override
    public Order transaction(Order order, String status, Date date) {
        Order order1 = orderRepository.save(order);

        for(TableDetail tableDetail: order.getTableDetailList()) {
            DiningTable diningTable = diningTableService.getTableByNumber(tableDetail.getDiningTable().getNumber());

            diningTable.setStatus(true);
            tableDetail.setDate(date.toLocalDate().atStartOfDay());
            diningTableService.saveTable(diningTable);
        }

        Customer customer = customerService.getCustomerByEmail(order.getCustomer().getEmail());
        order1.setCustomer(customer);
        order1.setStatus(status);
        return orderRepository.save(order1);
    }
}
