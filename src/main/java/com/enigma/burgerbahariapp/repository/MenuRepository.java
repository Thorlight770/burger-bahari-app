package com.enigma.burgerbahariapp.repository;

import com.enigma.burgerbahariapp.entity.master.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String>, JpaSpecificationExecutor {
}
