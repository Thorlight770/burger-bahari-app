package com.enigma.burgerbahariapp.dto.transaction;

import com.enigma.burgerbahariapp.entity.master.AddOn;
import com.enigma.burgerbahariapp.entity.master.Menu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MenuDetailDTO {
    private Menu menu;
    private AddOn addOn;
    private Integer quantity;
    private Double PriceDetail;
}
