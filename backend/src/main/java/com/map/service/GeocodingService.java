package com.map.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GeocodingService {

    @Value("${geocoding.api.key}")
    private String apiKey;
    @Value("${geocoding.api.scheme}")
    private String apiScheme;
    @Value("${geocoding.api.host}")
    private String apiHost;
    @Value("${geocoding.api.path}")
    private String apiPath;

    public String buildUri(String address) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme(apiScheme)
                .host(apiHost)
                .path(apiPath)
                .queryParam("key", apiKey)
                .queryParam("address", address)
                .build();
        return uri.toUriString();
    }
}