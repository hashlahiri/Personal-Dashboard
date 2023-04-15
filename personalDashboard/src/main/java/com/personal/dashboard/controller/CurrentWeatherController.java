package com.personal.dashboard.controller;

import com.personal.dashboard.domain.openWeatherMap.CurrentWeatherCityResponse;
import com.personal.dashboard.domain.openWeatherMap.CurrentWeatherRequest;
import com.personal.dashboard.domain.openWeatherMap.CurrentWeatherResponse;
import com.personal.dashboard.service.currentWeather.CurrentWeatherService;
import com.personal.dashboard.utils.APIEndpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = APIEndpoints.CURRENT_WEATHER_API_URL)
public class CurrentWeatherController {

    @Autowired
    private CurrentWeatherService currentWeatherService;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Get the current weather by latitude and longitude Endpoint
     *
     * @param currentWeatherRequest - {@link CurrentWeatherRequest}
     * @return - {@link CurrentWeatherResponse}
     */
    @RequestMapping(value = "/latLong", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrentWeatherResponse> getByLatLong(@RequestBody(required = true)CurrentWeatherRequest currentWeatherRequest) {

        CurrentWeatherResponse response = currentWeatherService.getByLatLongService(currentWeatherRequest);

        return new ResponseEntity<CurrentWeatherResponse>(response, HttpStatus.OK);
    }

    /**
     * Get the current weather by cityname (compulsory), stateCode, countryCode Endpoint
     *
     * @param city  - String city
     * @param stateCode - String stateCode
     * @param countryCode   - String countryCode
     * @return  - {@link CurrentWeatherCityResponse}
     */
    @RequestMapping(value = "/cityStateCountry", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrentWeatherCityResponse> getByCityStateCountry(
        @RequestParam(value = "city", required = true) String city,
        @RequestParam(value = "stateCode", required = false) String stateCode,
        @RequestParam(value = "countryCode", required = false) String countryCode
    ) {

        CurrentWeatherCityResponse response = currentWeatherService.getByCityStateCountryService(city, stateCode, countryCode);

        return new ResponseEntity<CurrentWeatherCityResponse>(response, HttpStatus.OK);
    }

    /**
     * Get the current weather by zipcode and country code endpoint
     *
     * @param zipCode - String zipCode
     * @param countryCode - String countryCode
     * @return - {@link CurrentWeatherCityResponse}
     */
    @RequestMapping(value = "/zipCodeCountry", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrentWeatherCityResponse> getByZipCodeCountry(
            @RequestParam(value = "zipCode", required = true) String zipCode,
            @RequestParam(value = "countryCode", required = true) String countryCode
    ) {

        CurrentWeatherCityResponse response = currentWeatherService.getByZipCodeCountryService(zipCode, countryCode);

        return new ResponseEntity<CurrentWeatherCityResponse>(response, HttpStatus.OK);
    }

}
