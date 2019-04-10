package com.lmbarquillo.curriculer.exceptions.generic;

import org.springframework.http.HttpStatus;

public class ConflictException extends CommonException {
    public ConflictException(String msg) {
        super(HttpStatus.CONFLICT.value(), msg);
    }
}
