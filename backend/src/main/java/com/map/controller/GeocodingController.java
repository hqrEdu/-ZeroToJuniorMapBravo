package com.map.controller;

import com.map.model.GeocodingResponse;
import com.map.service.GeocodingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/api/geocode")
@AllArgsConstructor
public class GeocodingController {

    private final GeocodingService geocodingService;
    @GetMapping()
    public GeocodingResponse getLocation(@RequestParam String address) {
        ResponseEntity<GeocodingResponse> response = new RestTemplate().getForEntity(geocodingService.buildUri(address), GeocodingResponse.class);
        return response.getBody();
    }
}
