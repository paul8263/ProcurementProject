package com.paul.web.exception;

/**
 * Created by paulzhang on 15/12/2016.
 */
public class UnauthorizedException extends Exception {
    public UnauthorizedException() {
    }

    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}
