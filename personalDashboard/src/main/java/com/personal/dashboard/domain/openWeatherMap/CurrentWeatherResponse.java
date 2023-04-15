package com.personal.dashboard.domain.openWeatherMap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("currentWeather")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CurrentWeatherResponse {

    private String cod;
    private String message;
    private Integer cnt;
    private List<ListObject> list;
    private City city;
}
