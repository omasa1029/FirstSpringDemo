package com.example.exception;

import org.springframework.validation.Errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class ApplicationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String errorCode;

    @Getter
    @Setter
    private Errors errors;
}
