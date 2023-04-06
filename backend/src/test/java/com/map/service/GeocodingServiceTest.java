package com.map.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = {GeocodingService.class})
@ExtendWith(SpringExtension.class)
class GeocodingServiceTest {

    @Autowired
    private GeocodingService geocodingService;

    @Test
    void testBuildUri() {
        assertEquals("https://maps.googleapis.com/maps/api/geocode/json?key=${geocoding.api.key}&address=Warszawa",
                geocodingService.buildUri("Warszawa"));
    }
}