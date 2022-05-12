package com.enigma.burgerbahariapp.service.master.impl;

import com.enigma.burgerbahariapp.dto.master.MenuDTO;
import com.enigma.burgerbahariapp.entity.master.Menu;
import com.enigma.burgerbahariapp.repository.master.MenuRepository;
import com.enigma.burgerbahariapp.service.master.MenuService;
import com.enigma.burgerbahariapp.specification.master.CustomMenuSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Page<Menu> getSpecificationMenu(Pageable pageable, MenuDTO menuDTO) {
        Specification<Menu> menuSpecification = CustomMenuSpecification.getSpecification(menuDTO);
        return menuRepository.findAll(menuSpecification, pageable);
    }

    @Override
    public Menu findMenuById(String idMenu) {
        return menuRepository.findById(idMenu).get();
    }

    @Override
    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public String deleteMenu(String idMenu) {
        if (menuRepository.existsById(idMenu)){
            menuRepository.deleteById(idMenu);
            return "Success deleted menu by id "+idMenu;
        }
        return "id "+idMenu+" NOT FOUND";
    }
}
