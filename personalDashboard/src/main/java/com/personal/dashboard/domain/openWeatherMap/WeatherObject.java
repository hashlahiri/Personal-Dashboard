package com.personal.dashboard.domain.openWeatherMap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class WeatherObject {

    private String id;
    private String main;
    private String description;
    private String icon;
}
