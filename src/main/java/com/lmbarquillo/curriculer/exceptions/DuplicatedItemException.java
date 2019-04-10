package com.lmbarquillo.curriculer.exceptions;

import com.lmbarquillo.curriculer.exceptions.generic.ConflictException;

public class DuplicatedItemException extends ConflictException {
    public DuplicatedItemException(String msg) {
        super(msg);
    }
}
