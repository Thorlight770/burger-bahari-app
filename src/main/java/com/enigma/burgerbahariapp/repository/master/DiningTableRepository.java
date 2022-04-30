package com.enigma.burgerbahariapp.repository.master;

import com.enigma.burgerbahariapp.entity.master.DiningTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiningTableRepository extends JpaRepository<DiningTable, String>, JpaSpecificationExecutor {
    Optional<DiningTable> findByNumber(Integer number);
}
