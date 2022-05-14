package com.enigma.burgerbahariapp.repository.transaction;

import com.enigma.burgerbahariapp.entity.transaction.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String >, JpaSpecificationExecutor {
}
