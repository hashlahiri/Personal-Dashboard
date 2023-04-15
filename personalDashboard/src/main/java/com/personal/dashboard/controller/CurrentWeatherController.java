package com.personal.dashboard.controller;

import com.personal.dashboard.domain.openWeatherMap.CurrentWeatherRequest;
import com.personal.dashboard.domain.openWeatherMap.CurrentWeatherResponse;
import com.personal.dashboard.service.currentWeather.CurrentWeatherService;
import com.personal.dashboard.utils.APIEndpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = APIEndpoints.CURRENT_WEATHER_API_URL)
public class CurrentWeatherController {

    @Autowired
    private CurrentWeatherService currentWeatherService;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Get the current weather by latitude and longitude
     *
     * @param currentWeatherRequest - {@link CurrentWeatherRequest}
     * @return - {@link CurrentWeatherResponse}
     */
    @RequestMapping(value = "/getByLatLong/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrentWeatherResponse> getByLatLong(@RequestBody(required = true)CurrentWeatherRequest currentWeatherRequest) {

        CurrentWeatherResponse response = currentWeatherService.getByLatLongService(currentWeatherRequest);

        return new ResponseEntity<CurrentWeatherResponse>(response, HttpStatus.OK);
    }

}
