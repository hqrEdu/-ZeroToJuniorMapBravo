package com.map.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GeocodingService.class})
@ExtendWith(SpringExtension.class)
class GeocodingServiceTest {

    @Autowired
    private GeocodingService geocodingService;

    @Test
    void shouldReturnCorrectUri() {

    }
}