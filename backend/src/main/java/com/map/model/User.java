package com.map.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String nickname;
    private String city;
    private String zipCode;
    private String country;

}