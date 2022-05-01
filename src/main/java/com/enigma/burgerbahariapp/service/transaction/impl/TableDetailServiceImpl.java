package com.enigma.burgerbahariapp.service.transaction.impl;

import com.enigma.burgerbahariapp.entity.master.DiningTable;
import com.enigma.burgerbahariapp.entity.transaction.TableDetail;
import com.enigma.burgerbahariapp.repository.transaction.TableDetailRepository;
import com.enigma.burgerbahariapp.service.transaction.TableDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TableDetailServiceImpl implements TableDetailService {
    @Autowired
    TableDetailRepository tableDetailRepository;

    @Override
    public void saveTableDetail(TableDetail tableDetail) {
        tableDetailRepository.save(tableDetail);
    }

    @Override
    public TableDetail getTableByTableIdAndDate(DiningTable diningTable, LocalDateTime from, LocalDateTime to) {
        if (tableDetailRepository.findByDiningTableAndAndDateBetween(diningTable, from, to).isPresent()) {
            return tableDetailRepository.findByDiningTableAndAndDateBetween(diningTable, from, to).get();
        } else {
            return null;
        }

    }
}
