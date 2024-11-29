package com.course.handles;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}