package com.enigma.burgerbahariapp.service;

import com.enigma.burgerbahariapp.dto.CustomerSearchDTO;
import com.enigma.burgerbahariapp.entity.master.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    Page<Customer> getAllCustomer(Pageable pageable);
    Page<Customer> getCustomerByData(Pageable pageable, CustomerSearchDTO customerSearchDTO);
    void deleteCustomer(String id);
    Customer getCustomerByEmail(String email);
}
