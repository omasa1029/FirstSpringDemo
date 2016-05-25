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

import com.example.common.ErrorCode;
import com.example.exception.ApplicationException;
import com.example.http.Responce;

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
    public Responce handleException(Exception exception) {
        return new Responce(ErrorCode.NG, "NoData", exception);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    public Responce handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        return new Responce(null);
    }

    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Responce handleApplicationException(ApplicationException exception) {
        return new Responce(null);
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Responce handleThrowable(Throwable throwable) {
        return new Responce(null);
    }
}
