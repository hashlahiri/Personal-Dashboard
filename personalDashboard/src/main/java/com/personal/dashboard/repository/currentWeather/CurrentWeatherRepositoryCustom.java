package com.personal.dashboard.repository.currentWeather;

import com.personal.dashboard.domain.openWeatherMap.CurrentWeatherRequest;
import com.personal.dashboard.domain.openWeatherMap.CurrentWeatherResponse;

public interface CurrentWeatherRepositoryCustom {

    public CurrentWeatherResponse getByLatLong(CurrentWeatherRequest currentWeatherRequest);
}
