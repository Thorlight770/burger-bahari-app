package com.enigma.burgerbahariapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerSearchDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private Boolean isDeleted;
}
