package com.guardless.springdocker.exception;

public class ApiRequestException extends RuntimeException{

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message,Throwable throwable){
        super(message,throwable);
    }
}
