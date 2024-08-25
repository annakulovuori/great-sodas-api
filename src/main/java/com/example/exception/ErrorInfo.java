package com.example.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorInfo {

    private String errorMsg;
    public ErrorInfo() {}
    public ErrorInfo(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
