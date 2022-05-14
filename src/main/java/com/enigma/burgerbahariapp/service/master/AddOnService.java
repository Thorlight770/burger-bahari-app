package com.enigma.burgerbahariapp.service.master;

import com.enigma.burgerbahariapp.dto.master.AddOnDTO;
import com.enigma.burgerbahariapp.entity.master.AddOn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AddOnService {
    Page<AddOn> getSpecificationAddOn(Pageable pageable, AddOnDTO addOnDTO);

    AddOn saveAddOn(AddOn addOn);

    AddOn findAddOnById(String idAddOn);

    String deleteAddOn(String idAddOn);
}
