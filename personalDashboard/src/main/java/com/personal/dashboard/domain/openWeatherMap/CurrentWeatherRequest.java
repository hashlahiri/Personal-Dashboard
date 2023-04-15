package com.personal.dashboard.domain.openWeatherMap;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.personal.dashboard.domain.enums.Lang;
import com.personal.dashboard.domain.enums.Units;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CurrentWeatherRequest {

    @JsonProperty("lat")
    private String latitude;  // REQUIRED

    @JsonProperty("lon")
    private String longitude; // REQUIRED

    @JsonProperty("units")
    private Units units;

    @JsonProperty("lang")
    private Lang language;

}
