package com.enigma.burgerbahariapp.service.master.impl;

import com.enigma.burgerbahariapp.dto.CustomerSearchDTO;
import com.enigma.burgerbahariapp.entity.master.Customer;
import com.enigma.burgerbahariapp.repository.master.CustomerRepository;
import com.enigma.burgerbahariapp.service.master.CustomerService;
import com.enigma.burgerbahariapp.specification.CustomerSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Page<Customer> getCustomer(Pageable pageable, CustomerSearchDTO customerSearchDTO) {
        Specification<Customer> customerSpecification = CustomerSpecification.getSpecification(customerSearchDTO);
        return customerRepository.findAll(customerSpecification, pageable);
    }

    @Override
    public void deleteCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();
        customer.setIsDeleted(true);
        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email).get();
    }
}
