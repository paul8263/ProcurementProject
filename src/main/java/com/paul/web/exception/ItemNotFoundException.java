package com.paul.web.exception;

/**
 * Created by paulzhang on 15/12/2016.
 */
public class ItemNotFoundException extends Exception {
    public ItemNotFoundException() {
    }

    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
