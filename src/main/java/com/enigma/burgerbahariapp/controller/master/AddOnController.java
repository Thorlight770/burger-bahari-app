package com.enigma.burgerbahariapp.controller.master;

import com.enigma.burgerbahariapp.dto.master.AddOnDTO;
import com.enigma.burgerbahariapp.entity.master.AddOn;
import com.enigma.burgerbahariapp.service.master.AddOnService;
import com.enigma.burgerbahariapp.util.PageResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addon")
public class AddOnController {
    @Autowired
    private AddOnService addOnService;

    @GetMapping
    public PageResponseWrapper<AddOn> getSpecificationAddOn(@RequestBody AddOnDTO addOnDTO,
                                                            @RequestParam(name = "page", defaultValue = "0")Integer page,
                                                            @RequestParam(name = "size", defaultValue = "3")Integer size,
                                                            @RequestParam(name = "sort", defaultValue = "name")String sort,
                                                            @RequestParam(name = "direction", defaultValue = "asc")String direction){
        System.out.println("ADD ON DTO "+ addOnDTO.getName());
        Sort sorting = Sort.by(Sort.Direction.fromString(direction), sort);
        Pageable pageable = PageRequest.of(page, size, sorting);
        Page<AddOn> addOns = addOnService.getSpecificationAddOn(pageable, addOnDTO);
        System.out.println("ADD ONS ELEMENT "+addOns.getTotalElements());
        return new PageResponseWrapper<>(addOns);
    }

    @PostMapping
    public AddOn createAddOn(@RequestBody AddOn addOn){
        return addOnService.saveAddOn(addOn);
    }

    @GetMapping("/{idAddon}")
    public AddOn getAddOnById(@PathVariable String idAddon){
        return addOnService.findAddOnById(idAddon);
    }

    @PutMapping
    public AddOn updateAddOn(@RequestBody AddOn addOn){
        return addOnService.saveAddOn(addOn);
    }

    @DeleteMapping
    public String removeAddOn(@RequestParam String idAddOn){
        return addOnService.deleteAddOn(idAddOn);
    }
}
