package com.enigma.burgerbahariapp.service;

import com.enigma.burgerbahariapp.dto.DiningTableSearchDTO;
import com.enigma.burgerbahariapp.entity.master.DiningTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DiningTableService {
    DiningTable saveTable(DiningTable diningTable);
    Page<DiningTable> getTable(Pageable pageable, DiningTableSearchDTO diningTableSearchDTO);
    DiningTable getTableByNumber(Integer number);
}
