package com.personal.dashboard.service.currentWeather;

import com.personal.dashboard.domain.openWeatherMap.CurrentWeatherCityResponse;
import com.personal.dashboard.domain.openWeatherMap.CurrentWeatherRequest;
import com.personal.dashboard.domain.openWeatherMap.CurrentWeatherResponse;
import com.personal.dashboard.repository.currentWeather.CurrentWeatherRepository;
import com.personal.dashboard.repository.currentWeatherCity.CurrentWeatherCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrentWeatherService {

    @Autowired
    private CurrentWeatherRepository currentWeatherRepository;

    @Autowired
    private CurrentWeatherCityRepository currentWeatherCityRepository;

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


    /**
     * Get the current weather by cityname (compulsory), stateCode, countryCode Service
     *
     * @param city  - String city
     * @param stateCode - String stateCode
     * @param countryCode   - String countryCode
     * @return  - {@link CurrentWeatherCityResponse}
     */
    public CurrentWeatherCityResponse getByCityStateCountryService(String city, String stateCode, String countryCode) {

        return currentWeatherCityRepository.getByCityStateCountry(city, stateCode, countryCode);
    }

    /**
     * Get the current weather by zipcode and country code Service
     *
     * @param zipCode - String zipCode
     * @param countryCode - String countryCode
     * @return - {@link CurrentWeatherCityResponse}
     */
    public CurrentWeatherCityResponse getByZipCodeCountryService(String zipCode, String countryCode) {

        return currentWeatherCityRepository.getByZipCodeCountry(zipCode, countryCode);
    }
}
