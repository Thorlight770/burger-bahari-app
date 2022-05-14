package com.enigma.burgerbahariapp.service.transaction.impl;

import com.enigma.burgerbahariapp.dto.transaction.MenuDetailDTO;
import com.enigma.burgerbahariapp.entity.master.AddOn;
import com.enigma.burgerbahariapp.entity.master.Menu;
import com.enigma.burgerbahariapp.entity.transaction.MenuDetail;
import com.enigma.burgerbahariapp.repository.transaction.MenuDetailRepository;
import com.enigma.burgerbahariapp.service.master.AddOnService;
import com.enigma.burgerbahariapp.service.master.MenuService;
import com.enigma.burgerbahariapp.service.transaction.MenuDetailService;
import com.enigma.burgerbahariapp.specification.transaction.CustomMenuDetailSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MenuDetailServiceImpl implements MenuDetailService {
    @Autowired
    private MenuDetailRepository menuDetailRepository;

    @Autowired
    private MenuService menuService;

    @Autowired
    private AddOnService addOnService;

    @Override
    public Page<MenuDetail> getMenuDetailSpecification(Pageable pageable, MenuDetailDTO menuDetailDTO) {
        Specification<MenuDetail> specification = CustomMenuDetailSpecification.getMenuDetailSpecification(menuDetailDTO);
        return menuDetailRepository.findAll(specification, pageable);
    }

    @Override
    @Transactional
    public MenuDetail saveMenuDetail(MenuDetail menuDetail) {
        Menu menu = menuService.findMenuById(menuDetail.getMenu().getId());
        AddOn addOn = addOnService.findAddOnById(menuDetail.getAddOn().getId());

        Double priceDetail = (menu.getPrice() + addOn.getPrice()) * menuDetail.getQuantity();

        menuDetail.setPriceDetail(priceDetail);
        return menuDetailRepository.save(menuDetail);
    }

    @Override
    public MenuDetail getMenuDetailById(String idMenuDetail) {
        return menuDetailRepository.findById(idMenuDetail).get();
    }

    @Override
    public String deleteMenuDetailById(String idMenuDetail) {
        if (menuDetailRepository.existsById(idMenuDetail)){
            menuDetailRepository.deleteById(idMenuDetail);
            return "Success delete menu detail id "+idMenuDetail;
        }else {
            return "id "+idMenuDetail+" not found";
        }
    }
}
