package com.enigma.burgerbahariapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddOnDTO {
    private String name;
    private String description;
    private Double priceCheapest;
    private Double priceExpensive;
}
