package com.enigma.burgerbahariapp.service.transaction;

import com.enigma.burgerbahariapp.dto.transaction.MenuDetailDTO;
import com.enigma.burgerbahariapp.entity.transaction.MenuDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MenuDetailService {
    Page<MenuDetail> getMenuDetailSpecification(Pageable pageable, MenuDetailDTO menuDetailDTO);

    MenuDetail saveMenuDetail(MenuDetail menuDetail);

    MenuDetail getMenuDetailById(String idMenuDetail);

    String deleteMenuDetailById(String idMenuDetail);
}
