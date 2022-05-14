package com.enigma.burgerbahariapp.controller.transaction;

import com.enigma.burgerbahariapp.dto.transaction.MenuDetailDTO;
import com.enigma.burgerbahariapp.entity.transaction.MenuDetail;
import com.enigma.burgerbahariapp.service.transaction.MenuDetailService;
import com.enigma.burgerbahariapp.util.PageResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menudetail")
public class MenuDetailController {
    @Autowired
    private MenuDetailService menuDetailService;

    @GetMapping
    public PageResponseWrapper<MenuDetail> getMenuDetailSpecification(@RequestBody MenuDetailDTO menuDetailDTO,
                                                                      @RequestParam(name = "page", defaultValue = "0")Integer page,
                                                                      @RequestParam(name = "size", defaultValue = "3")Integer size,
                                                                      @RequestParam(name = "sort", defaultValue = "id")String sort,
                                                                      @RequestParam(name = "direction", defaultValue = "asc")String direction){
        Sort sorting = Sort.by(Sort.Direction.fromString(direction), sort);
        Pageable pageable =PageRequest.of(page, size, sorting);
        Page<MenuDetail> menuDetails = menuDetailService.getMenuDetailSpecification(pageable, menuDetailDTO);
        return new PageResponseWrapper<>(menuDetails);
    }

    @PostMapping
    public MenuDetail createMenuDetail(@RequestBody MenuDetail menuDetail){
        return menuDetailService.saveMenuDetail(menuDetail);
    }

    @PutMapping
    public MenuDetail updateMenuDetail(@RequestBody MenuDetail menuDetail){
        return menuDetailService.saveMenuDetail(menuDetail);
    }

    @DeleteMapping
    public String removeMenuDetail(@RequestParam String idMenuDetail){
        return menuDetailService.deleteMenuDetailById(idMenuDetail);
    }

    @GetMapping("/{idMenuDetail}")
    public MenuDetail getMenuDetailById(@PathVariable String idMenuDetail){
        return menuDetailService.getMenuDetailById(idMenuDetail);
    }
}
