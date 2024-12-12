package com.example.monumentos_CarlosRuiz.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monument {

    private Long id;
    private String codCountry;
    private String country;
    private String city;
    private Double latitude;
    private Double length;
    private String description;
    private String monumentName;
    private String urlImage;

}
