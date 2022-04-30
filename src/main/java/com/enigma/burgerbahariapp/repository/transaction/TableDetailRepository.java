package com.enigma.burgerbahariapp.repository.transaction;

import com.enigma.burgerbahariapp.entity.transaction.TableDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TableDetailRepository extends JpaRepository<TableDetail, String>, JpaSpecificationExecutor {
}
