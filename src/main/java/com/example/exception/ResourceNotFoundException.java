package com.example.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends IllegalArgumentException {

    final private int sodaId;

    public ResourceNotFoundException(int id) {
        sodaId = id;

    }
}
