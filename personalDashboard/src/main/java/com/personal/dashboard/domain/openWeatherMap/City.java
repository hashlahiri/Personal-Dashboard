package com.personal.dashboard.domain.openWeatherMap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class City {

    private Double id;
    private String name;
    private Coord coord;
    private String country;
    private Double population;
    private Double timezone;
    private Long sunrise;
    private Long sunset;
}
