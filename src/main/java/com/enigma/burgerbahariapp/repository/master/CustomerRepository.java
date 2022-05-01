package com.enigma.burgerbahariapp.repository.master;

import com.enigma.burgerbahariapp.entity.master.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>, JpaSpecificationExecutor {
    Optional<Customer> findByEmail(String email);
}
