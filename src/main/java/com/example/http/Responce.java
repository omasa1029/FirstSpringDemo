package com.example.http;

import com.example.common.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Responce {
    private ErrorCode errorCode = ErrorCode.OK;
    private String errorMessage = "";
    private Object content;

    public Responce(Object content) {
        setContent(content);
    }
}
