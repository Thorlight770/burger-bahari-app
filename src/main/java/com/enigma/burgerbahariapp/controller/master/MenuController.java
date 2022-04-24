package com.enigma.burgerbahariapp.controller.master;

import com.enigma.burgerbahariapp.dto.MenuDTO;
import com.enigma.burgerbahariapp.entity.master.Menu;
import com.enigma.burgerbahariapp.service.master.MenuService;
import com.enigma.burgerbahariapp.util.PageResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${menu.url}")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping
    public PageResponseWrapper<Menu> menuPageResponseWrapper(@RequestParam MenuDTO menuDTO,
                                                             @RequestParam(name = "page", defaultValue = "0")Integer page,
                                                             @RequestParam(name = "size", defaultValue = "3")Integer size,
                                                             @RequestParam(name = "sort", defaultValue = "idMenu") String sort,
                                                             @RequestParam(name = "direction", defaultValue = "asc") String direction) {
        Sort sorting = Sort.by(Sort.Direction.fromString(direction), sort);
        Pageable pageable = PageRequest.of(page, size, sorting);
        Page<Menu> customers = menuService.getSpecificationMenu(pageable, menuDTO);
        return new PageResponseWrapper<>(customers);
    }

    @PostMapping
    public Menu createMenu(@RequestBody Menu menu){
        return menuService.saveMenu(menu);
    }

    @PutMapping
    public Menu updateMenu(@RequestBody Menu menu){
        return menuService.saveMenu(menu);
    }

    @DeleteMapping
    public String removeMenu(@RequestParam String idMenu){
        return menuService.deleteMenu(idMenu);
    }
}
