package com.example.common;

public enum ErrorCode {
    OK(0), NG(1);

    private final int value;

    private ErrorCode(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
