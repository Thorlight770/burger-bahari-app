package com.enigma.burgerbahariapp.controller.master;

import com.enigma.burgerbahariapp.dto.CustomerSearchDTO;
import com.enigma.burgerbahariapp.entity.master.Customer;
import com.enigma.burgerbahariapp.service.master.CustomerService;
import com.enigma.burgerbahariapp.util.PageResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping
    public PageResponseWrapper<Customer> getCustomer(@RequestBody CustomerSearchDTO customerSearchDTO,
                                                           @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                           @RequestParam(name = "size", defaultValue = "3") Integer sizePerPage,
                                                           @RequestParam(name = "sort", defaultValue = "name") String sort,
                                                           @RequestParam(name = "direction", defaultValue = "ASC") Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, sizePerPage, Sort.by(direction, sort));
        Page<Customer> customerPage = customerService.getCustomer(pageable, customerSearchDTO);
        return new PageResponseWrapper<>(customerPage);
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/delete")
    public void deleteCustomer(@RequestParam String id) {
        customerService.deleteCustomer(id);
    }
}
