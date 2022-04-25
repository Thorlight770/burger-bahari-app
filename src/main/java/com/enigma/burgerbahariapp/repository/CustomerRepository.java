package com.enigma.burgerbahariapp.repository;

import com.enigma.burgerbahariapp.entity.master.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>, JpaSpecificationExecutor {
    Page<Customer> findAll(Pageable pageable);
    Optional<Customer> findByEmail(String email);
}
