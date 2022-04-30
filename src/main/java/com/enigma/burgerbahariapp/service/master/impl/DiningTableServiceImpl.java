package com.enigma.burgerbahariapp.service.master.impl;

import com.enigma.burgerbahariapp.constant.ResponseMessage;
import com.enigma.burgerbahariapp.dto.DiningTableSearchDTO;
import com.enigma.burgerbahariapp.entity.master.DiningTable;
import com.enigma.burgerbahariapp.exception.DataAlreadyUsed;
import com.enigma.burgerbahariapp.exception.DataNotFoundException;
import com.enigma.burgerbahariapp.repository.master.DiningTableRepository;
import com.enigma.burgerbahariapp.service.master.DiningTableService;
import com.enigma.burgerbahariapp.specification.DiningTableSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class DiningTableServiceImpl implements DiningTableService {
    @Autowired
    DiningTableRepository diningTableRepository;

    @Override
    public DiningTable saveTable(DiningTable diningTable) {
        if (diningTableRepository.findByNumber(diningTable.getNumber()).isPresent()) {
            throw new DataAlreadyUsed(String.format(ResponseMessage.DATA_IS_USED, "table", diningTable.getNumber()));
        }
        return diningTableRepository.save(diningTable);
    }

    @Override
    public Page<DiningTable> getTable(Pageable pageable, DiningTableSearchDTO diningTableSearchDTO) {
        Specification<DiningTable> diningTableSpecification = DiningTableSpecification.getSpecification(diningTableSearchDTO);
        return diningTableRepository.findAll(diningTableSpecification, pageable);
    }

    @Override
    public DiningTable getTableByNumber(Integer number) {
        if (!(diningTableRepository.findByNumber(number).isPresent())) {
            throw new DataNotFoundException(String.format(ResponseMessage.DATA_NOT_FOUND, "table", number));
        }
        return diningTableRepository.findByNumber(number).get();
    }
}
