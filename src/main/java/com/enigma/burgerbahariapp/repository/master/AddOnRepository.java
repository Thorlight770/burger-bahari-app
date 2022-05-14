package com.enigma.burgerbahariapp.repository.master;

import com.enigma.burgerbahariapp.entity.master.AddOn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AddOnRepository extends JpaRepository<AddOn, String>, JpaSpecificationExecutor {
}
