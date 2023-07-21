package com.andyegor.exception;

public class CollectionEmptyException extends Exception {


    public CollectionEmptyException() {
    }

    public CollectionEmptyException(String message) {
        super(message);
    }

    public CollectionEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
