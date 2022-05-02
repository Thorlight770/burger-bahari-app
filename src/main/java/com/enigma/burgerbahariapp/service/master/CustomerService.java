package com.enigma.burgerbahariapp.service.master;

import com.enigma.burgerbahariapp.dto.master.CustomerSearchDTO;
import com.enigma.burgerbahariapp.entity.master.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    Page<Customer> getCustomer(Pageable pageable, CustomerSearchDTO customerSearchDTO);
    void deleteCustomer(String id);
    Customer getCustomerByEmail(String email);
}
