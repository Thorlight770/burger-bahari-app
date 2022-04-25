package com.enigma.burgerbahariapp.service.impl;

import com.enigma.burgerbahariapp.dto.DiningTableSearchDTO;
import com.enigma.burgerbahariapp.entity.master.DiningTable;
import com.enigma.burgerbahariapp.repository.DiningTableRepository;
import com.enigma.burgerbahariapp.service.DiningTableService;
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
        return diningTableRepository.save(diningTable);
    }

    @Override
    public Page<DiningTable> getTable(Pageable pageable, DiningTableSearchDTO diningTableSearchDTO) {
        Specification<DiningTable> diningTableSpecification = DiningTableSpecification.getSpecification(diningTableSearchDTO);
        return diningTableRepository.findAll(diningTableSpecification, pageable);
    }

    @Override
    public DiningTable getTableByNumber(Integer number) {
        return diningTableRepository.findByNumber(number).get();
    }
}