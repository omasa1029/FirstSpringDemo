package com.example.aspect;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.exception.ApplicationException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("controller advice: init binder");
    }

    @ModelAttribute
    public void modelAttribute() {
        System.out.println("controller advice:model Attribute");
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Exception handleException(Exception exception) {
        return null;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    public Exception handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        return null;
    }

    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Exception handleApplicationException(ApplicationException exception) {
        return null;
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Throwable handleThrowable(Throwable throwable) {
        return null;
    }
}
