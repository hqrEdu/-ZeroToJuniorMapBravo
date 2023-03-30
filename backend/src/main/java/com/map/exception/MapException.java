package com.map.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MapException extends RuntimeException {
    private final HttpStatus status;

    protected MapException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    HttpStatus getHttpStatus() {
        return status;
    }
}