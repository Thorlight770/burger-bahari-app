package com.enigma.burgerbahariapp.service.master.impl;

import com.enigma.burgerbahariapp.dto.master.AddOnDTO;
import com.enigma.burgerbahariapp.entity.master.AddOn;
import com.enigma.burgerbahariapp.repository.master.AddOnRepository;
import com.enigma.burgerbahariapp.service.master.AddOnService;
import com.enigma.burgerbahariapp.specification.master.CustomAddOnSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class AddOnServiceImpl implements AddOnService {
    @Autowired
    private AddOnRepository addOnRepository;

    @Override
    public Page<AddOn> getSpecificationAddOn(Pageable pageable, AddOnDTO addOnDTO) {
        Specification<AddOn> addOnSpecification = CustomAddOnSpecification.getSpecification(addOnDTO);
        return addOnRepository.findAll(addOnSpecification, pageable);
    }

    @Override
    public AddOn saveAddOn(AddOn addOn) {
        return addOnRepository.save(addOn);
    }

    @Override
    public AddOn findAddOnById(String idAddOn) {
        return addOnRepository.findById(idAddOn).get();
    }

    @Override
    public String deleteAddOn(String idAddOn) {
        if (addOnRepository.existsById(idAddOn)){
            addOnRepository.deleteById(idAddOn);
            return "Success delete id "+idAddOn+" from repository";
        }else {
            return "id "+idAddOn+" not found";
        }
    }
}
