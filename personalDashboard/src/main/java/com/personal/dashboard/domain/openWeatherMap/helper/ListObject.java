package com.personal.dashboard.domain.openWeatherMap.helper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ListObject {

    private Long dt;
    private MainObject main;
    private List<WeatherObject> weather;
    private CloudsObject clouds;
    private WindObject windObject;
    private Long visibility;
    private Double pop;
    private SysObject sys;

    @JsonProperty("dt_txt")
    private String dtTxt;
}
