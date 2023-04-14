package com.map.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ContextConfiguration(classes = {GeocodingService.class})
@ExtendWith(SpringExtension.class)
class GeocodingServiceTest {

    @Autowired
    private GeocodingService geocodingService;

    @Test
    void shouldReturnCorrectUri() {
        assertEquals("${geocoding.api.scheme}" + "://" + "${geocoding.api.host}" + "/" + "${geocoding.api.path}" + "?key=" + "${geocoding.api.key}&address=Warszawa",
                geocodingService.buildUri("Warszawa"));
    }

    @Test
    void shouldReturnIncorrectUri() {
        assertNotEquals("${geocoding.api.scheme}" + "${geocoding.api.host}" + "${geocoding.api.path}" + "?key=" + "${geocoding.api.key}&address=Warszawa",
                geocodingService.buildUri("Kielce"));
    }
}