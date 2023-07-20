package com.andyegor.exception;

public class NoBandFoundException extends Exception{
    public NoBandFoundException() {
    }

    public NoBandFoundException(String message) {
        super(message);
    }

    public NoBandFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
