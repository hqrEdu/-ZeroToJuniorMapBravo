package com.map.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GeocodingResponse {

    @JsonProperty("results")
    private List<Result> result;
}
