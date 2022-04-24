package com.enigma.burgerbahariapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class MenuDTO {
    private String idMenu;
    private Double priceCheapest;
    private Double priceExpensive;
    private String description;
}
