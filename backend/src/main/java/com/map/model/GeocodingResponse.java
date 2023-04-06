package com.map.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GeocodingResponse {

    @JsonProperty("results")
    private Result[] result;
}
