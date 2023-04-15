package com.map.exception;

import org.springframework.http.HttpStatus;

public class LongitudeException extends MapException {

    private static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.BAD_REQUEST;

    public LongitudeException(String address) {
        super(String.format("Error while getting longitude for address: {address=%s}", address), DEFAULT_HTTP_STATUS);
    }
}