package com.enigma.burgerbahariapp.service.transaction;

import com.enigma.burgerbahariapp.entity.master.DiningTable;
import com.enigma.burgerbahariapp.entity.transaction.TableDetail;

import java.time.LocalDateTime;

public interface TableDetailService {
    void saveTableDetail(TableDetail tableDetail);
    TableDetail getTableByTableIdAndDate(DiningTable diningTable, LocalDateTime from, LocalDateTime to);
}
