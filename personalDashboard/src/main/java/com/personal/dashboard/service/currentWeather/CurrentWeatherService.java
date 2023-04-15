package com.personal.dashboard.service.currentWeather;

import com.personal.dashboard.domain.openWeatherMap.CurrentWeatherRequest;
import com.personal.dashboard.domain.openWeatherMap.CurrentWeatherResponse;
import com.personal.dashboard.repository.currentWeather.CurrentWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrentWeatherService {

    @Autowired
    private CurrentWeatherRepository currentWeatherRepository;

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(CurrentWeatherService.class);

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Get the current weather by latitude and longitude Service
     *
     * @param currentWeatherRequest - {@link CurrentWeatherRequest}
     * @return - {@link CurrentWeatherResponse}
     */
    public CurrentWeatherResponse getByLatLongService(CurrentWeatherRequest currentWeatherRequest) {

        return currentWeatherRepository.getByLatLong(currentWeatherRequest);
    }


}
