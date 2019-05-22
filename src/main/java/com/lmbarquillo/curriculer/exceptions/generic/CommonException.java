package com.lmbarquillo.curriculer.exceptions.generic;

public abstract class CommonException extends Exception{
    private ErrorModel error;

    public CommonException(int code, String msg) {
        super(msg);
        setError(new ErrorModel(code, msg));
    }

    public void setError(ErrorModel error) {
        this.error = error;
    }

    public ErrorModel getError() {
        return error;
    }
}
