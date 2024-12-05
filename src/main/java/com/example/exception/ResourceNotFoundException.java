package com.example.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends IllegalArgumentException {


    public ResourceNotFoundException(String msg) {
         super(msg);

    }
}
