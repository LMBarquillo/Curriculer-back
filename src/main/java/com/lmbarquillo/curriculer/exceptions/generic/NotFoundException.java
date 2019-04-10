package com.lmbarquillo.curriculer.exceptions.generic;

import org.springframework.http.HttpStatus;

public class NotFoundException extends CommonException {
    public NotFoundException(String msg) {
        super(HttpStatus.NOT_FOUND.value(), msg);
    }
}
