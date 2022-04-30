package com.enigma.burgerbahariapp.controller.master;

import com.enigma.burgerbahariapp.dto.DiningTableSearchDTO;
import com.enigma.burgerbahariapp.entity.master.DiningTable;
import com.enigma.burgerbahariapp.service.master.DiningTableService;
import com.enigma.burgerbahariapp.util.PageResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tables")
public class DiningTableController {
    @Autowired
    DiningTableService diningTableService;

    @PostMapping
    public DiningTable saveTable(@RequestBody DiningTable diningTable) {
        return diningTableService.saveNewTable(diningTable);
    }

    @GetMapping
    public PageResponseWrapper<DiningTable> getTable(@RequestBody DiningTableSearchDTO diningTableSearchDTO,
                                                     @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                     @RequestParam(name = "size", defaultValue = "5") Integer sizePerPage,
                                                     @RequestParam(name = "sort", defaultValue = "number") String sort,
                                                     @RequestParam(name = "direction", defaultValue = "ASC") Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, sizePerPage, Sort.by(direction, sort));
        Page<DiningTable> diningTablePage = diningTableService.getTable(pageable, diningTableSearchDTO);
        return new PageResponseWrapper<>(diningTablePage);
    }
}
