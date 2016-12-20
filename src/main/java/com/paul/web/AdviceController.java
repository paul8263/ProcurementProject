package com.paul.web;

import com.paul.web.exception.ItemNotFoundException;
import com.paul.web.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by paulzhang on 20/12/2016.
 */
@ControllerAdvice
public class AdviceController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException() {
        return "error";
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = UnauthorizedException.class)
    public String handleUnauthorizedException() {
        return "error";
    }

    @ExceptionHandler(value = ItemNotFoundException.class)
    public String handleItemNotFoundException() {
        return "error";
    }

}
