package com.personal.dashboard.domain.openWeatherMap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class SysCityObject {
    private String country;
    private String id;
    private Double sunrise;
    private Double sunset;
    private Integer type;
}
