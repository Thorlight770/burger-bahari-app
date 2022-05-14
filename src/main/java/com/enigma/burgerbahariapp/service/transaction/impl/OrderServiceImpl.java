package com.enigma.burgerbahariapp.service.transaction.impl;

import com.enigma.burgerbahariapp.constant.ResponseMessage;
import com.enigma.burgerbahariapp.entity.master.Customer;
import com.enigma.burgerbahariapp.entity.master.DiningTable;
import com.enigma.burgerbahariapp.entity.master.Menu;
import com.enigma.burgerbahariapp.entity.transaction.MenuDetail;
import com.enigma.burgerbahariapp.entity.transaction.Order;
import com.enigma.burgerbahariapp.entity.transaction.OrderDetail;
import com.enigma.burgerbahariapp.entity.transaction.TableDetail;
import com.enigma.burgerbahariapp.exception.DataAlreadyUsed;
import com.enigma.burgerbahariapp.repository.transaction.OrderRepository;
import com.enigma.burgerbahariapp.service.master.CustomerService;
import com.enigma.burgerbahariapp.service.master.DiningTableService;
import com.enigma.burgerbahariapp.service.transaction.MenuDetailService;
import com.enigma.burgerbahariapp.service.transaction.OrderDetailService;
import com.enigma.burgerbahariapp.service.transaction.OrderService;
import com.enigma.burgerbahariapp.service.transaction.TableDetailService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    DiningTableService diningTableService;

    @Autowired
    CustomerService customerService;

    @Autowired
    TableDetailService tableDetailService;

    @Autowired
    MenuDetailService menuDetailService;

    @Autowired
    OrderDetailService orderDetailService;

    @Override
    @Transient
    @Transactional
    public Order transaction(Order order) {
        Customer customer = customerService.getCustomerByEmail(order.getCustomer().getEmail());
        order.setCustomer(customer);

        Order order1 = orderRepository.save(order);

        LocalDateTime localDateTime = null;
        Boolean menu = false;
        List<OrderDetail> orderDetailListTemp = new ArrayList<>();
        order1.setStatus("direct");

        for(TableDetail tableDetail: order1.getTableDetailList()) {
            tableDetail.setOrder(order1);

            DiningTable diningTable = diningTableService.getTableByNumber(tableDetail.getDiningTable().getNumber());
            if (tableDetail.getDate()==null && localDateTime==null) {
                localDateTime = LocalDateTime.now();
            } else if (tableDetail.getDate()!=null) {
                localDateTime = tableDetail.getDate();
                order1.setStatus("book");
            }

            if (order1.getStatus().equals("book")) {
                if (tableDetailService.getTableByTableIdAndDate(diningTable, localDateTime.minusHours(1), localDateTime.plusHours(1))!=null) {
                    throw new DataAlreadyUsed(String.format(ResponseMessage.DATA_IS_USED, "customer", customer.getEmail()));
                }
            } else {
                if (diningTable.getStatus().equals(true)) {
                    throw new DataAlreadyUsed(String.format(ResponseMessage.DATA_IS_USED, "customer", customer.getEmail()));
                } else {
                    diningTable.setStatus(true);
                }
            }
            diningTableService.saveTable(diningTable);

            if (!menu) {
                Double subTotal = 0.0;
                for(OrderDetail orderDetail: tableDetail.getOrderDetailList()) {
                    orderDetail.setTableDetail(tableDetail);
                    MenuDetail menuDetail = orderDetail.getMenuDetail();

                    menuDetailService.saveMenuDetail(menuDetail);

                    orderDetail.setMenuDetail(menuDetail);

                    subTotal += menuDetail.getPriceDetail();

                    orderDetail.setSubtotal(subTotal);

                    orderDetailService.saveOrderDetail(orderDetail);
                    orderDetailListTemp.add(orderDetail);
                }
                menu = true;
            } else {
                tableDetail.setOrderDetailList(orderDetailListTemp);
            }

            tableDetail.setDate(localDateTime);
            tableDetail.setDiningTable(diningTable);
            tableDetailService.saveTableDetail(tableDetail);
        }
        return orderRepository.save(order1);
    }
}
