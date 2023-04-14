package com.map.dto;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class UserDto {

    @NotNull
    private String nickname;
    @NotNull
    private String city;
    @NotNull
    private String zipCode;
    @NotNull
    private String country;
    @NotNull
    private float latitude;
    @NotNull
    private float longitude;
}