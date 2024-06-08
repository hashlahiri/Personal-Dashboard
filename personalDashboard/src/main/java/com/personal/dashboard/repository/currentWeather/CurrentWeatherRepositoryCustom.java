package com.personal.dashboard.repository.currentWeather;

import com.personal.dashboard.domain.mongo.openWeatherMap.CurrentWeatherRequest;
import com.personal.dashboard.domain.mongo.openWeatherMap.CurrentWeatherResponse;

public interface CurrentWeatherRepositoryCustom {

    public CurrentWeatherResponse getByLatLong(CurrentWeatherRequest currentWeatherRequest);
}
