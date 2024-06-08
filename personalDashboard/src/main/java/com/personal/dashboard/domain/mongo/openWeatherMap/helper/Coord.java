package com.personal.dashboard.domain.mongo.openWeatherMap.helper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Coord {

    private Double lat;
    private Double lon;
}
