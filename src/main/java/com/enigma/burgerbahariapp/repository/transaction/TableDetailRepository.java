package com.enigma.burgerbahariapp.repository.transaction;

import com.enigma.burgerbahariapp.entity.master.DiningTable;
import com.enigma.burgerbahariapp.entity.transaction.TableDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface TableDetailRepository extends JpaRepository<TableDetail, String>, JpaSpecificationExecutor {
    Optional<TableDetail> findByDateAndDiningTable(LocalDateTime date, DiningTable diningTable);
}
