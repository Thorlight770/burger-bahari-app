package com.enigma.burgerbahariapp.service.master;

import com.enigma.burgerbahariapp.dto.master.MenuDTO;
import com.enigma.burgerbahariapp.entity.master.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MenuService {
    Page<Menu> getSpecificationMenu(Pageable pageable, MenuDTO menuDTO);

    Menu findMenuById(String idMenu);

    Menu saveMenu(Menu menu);

    String deleteMenu(String idMenu);
}
