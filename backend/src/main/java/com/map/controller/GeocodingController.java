package com.map.controller;

import com.map.model.GeocodingResponse;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/api/geocode")
@AllArgsConstructor
public class GeocodingController {

    @GetMapping()
    public GeocodingResponse getLocation() {
        ResponseEntity<GeocodingResponse> response = new RestTemplate().getForEntity("https://maps.googleapis.com/maps/api/geocode/json?address=Bodzentyn&key=AIzaSyBfLK6ciOnBQSI7onqBs623AI_0b9uQOAc"
                , GeocodingResponse.class);
        return response.getBody();
    }
}
