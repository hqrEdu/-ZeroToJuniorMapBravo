package com.map.service;

import com.map.model.GeocodingResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GeocodingService {

    private static final Logger LOG = LoggerFactory.getLogger(GeocodingService.class);

    @Value("${geocoding.api.key}")
    private String apiKey;
    @Value("${geocoding.api.scheme}")
    private String apiScheme;
    @Value("${geocoding.api.host}")
    private String apiHost;
    @Value("${geocoding.api.path}")
    private String apiPath;

    public Float getLatitude(String address) {
        GeocodingResponse result = getJson(address);
        return (result.getResult().get(0).getGeometry().getLocation().getLat());
    }

    public Float getLongitude(String address) {
        GeocodingResponse result = getJson(address);
        return (result.getResult().get(0).getGeometry().getLocation().getLng());
    }

    private GeocodingResponse getJson(String address) {
        ResponseEntity<GeocodingResponse> response = new RestTemplate().getForEntity(buildUri(address), GeocodingResponse.class);
        return response.getBody();
    }

    private String buildUri(String address) {
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