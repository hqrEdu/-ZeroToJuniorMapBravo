package com.map.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GeocodingService {

    @Value("${geocoding.api.key}")
    private String apiKey;

    public String buildUri(String address) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("maps.googleapis.com")
                .path("/maps/api/geocode/json")
                .queryParam("key", apiKey)
                .queryParam("address", address)
                .build();
        return uri.toUriString();
    }
}