package com.enigma.burgerbahariapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class MenuDTO {
    private String name;
    private Double priceCheapest;
    private Double priceExpensive;
    private String description;
}
