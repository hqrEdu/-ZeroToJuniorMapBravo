package com.map.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = GeocodingService.class)
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application.properties")
class GeocodingServiceTest {

    @Autowired
    private GeocodingService geocodingService;

    @Test
    void shouldCorrectlyReturnLatitude() {
        String address = "Poland Kielce 26-001";
        Float expectedValue = 50.905518f;
        assertEquals(expectedValue, geocodingService.getLatitude(address));
    }

    @Test
    void shouldCorrectlyReturnLongitude() {
        String address = "Poland Kielce 26-001";
        Float expectedValue = 20.723066f;
        assertEquals(expectedValue, geocodingService.getLongitude(address));
    }
}