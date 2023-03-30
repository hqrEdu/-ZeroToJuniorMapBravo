package com.map.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistException extends MapException {

    private static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.BAD_REQUEST;

    public UserAlreadyExistException(String nickname) {
        super(String.format("User with nickname exist. {nickname=%s}", nickname), DEFAULT_HTTP_STATUS);
    }
}