package com.enigma.burgerbahariapp.repository;

import com.enigma.burgerbahariapp.entity.master.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, String> {
}
