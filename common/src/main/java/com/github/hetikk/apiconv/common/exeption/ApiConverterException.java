package com.github.hetikk.apiconv.common.exeption;

public class ApiConverterException extends RuntimeException {

    public ApiConverterException() {
    }

    public ApiConverterException(String message) {
        super(message);
    }

    public ApiConverterException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiConverterException(Throwable cause) {
        super(cause);
    }

    public ApiConverterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
