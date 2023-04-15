package com.map.exception;

import org.springframework.http.HttpStatus;

public class LatitudeException extends MapException {

    private static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.BAD_REQUEST;

    public LatitudeException(String address) {
        super(String.format("Error while getting latitude for address: {address=%s}", address), DEFAULT_HTTP_STATUS);
    }
}