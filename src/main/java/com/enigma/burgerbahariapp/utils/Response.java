package com.enigma.burgerbahariapp.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T>{
    private String message;
    private T data;
}
