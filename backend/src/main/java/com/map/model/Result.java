package com.map.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Result {

    @JsonProperty("formatted_address")
    private String address;
    private Geometry geometry;
}