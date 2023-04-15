package com.personal.dashboard.repository.currentWeatherCity;

import com.personal.dashboard.domain.enums.ErrorResponseEnum;
import com.personal.dashboard.domain.openWeatherMap.CurrentWeatherCityResponse;
import com.personal.dashboard.exception.ValidationError;
import com.personal.dashboard.exception.ValidationException;
import com.personal.dashboard.utils.OpenWeatherMapUtility;
import com.personal.dashboard.validation.CurrentWeatherValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CurrentWeatherCityRepositoryImpl implements CurrentWeatherCityRepositoryCustom{

    @Autowired
    private CurrentWeatherCityRepository currentWeatherCityRepository;

    @Autowired
    private OpenWeatherMapUtility openWeatherMapUtility;

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(CurrentWeatherCityRepositoryImpl.class);

    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Get the current weather by cityname (compulsory), stateCode, countryCode
     *
     * @param city  - String city
     * @param stateCode - String stateCode
     * @param countryCode   - String countryCode
     * @return  - {@link CurrentWeatherCityResponse}
     */
    @Override
    public CurrentWeatherCityResponse getByCityStateCountry(String city, String stateCode, String countryCode) {

        //Validation
        List<ValidationError> validationErrorList = CurrentWeatherValidator.validateCurrentWeatherByCityStateCountry(city, stateCode, countryCode);
        if (!validationErrorList.isEmpty()) {
            LOG.error("Could not get current weather by city due to insufficient data.");
            throw new ValidationException(validationErrorList, ErrorResponseEnum.VALIDATION_ERROR);
        }

        CurrentWeatherCityResponse currentWeatherCityResponse = CurrentWeatherCityResponse.builder().build();
        try {
            // 3rd part API invoked
            currentWeatherCityResponse = openWeatherMapUtility.invokeCurrentWeatherCityResponseReport(city, stateCode, countryCode);

            // if response is successful
            if(currentWeatherCityResponse != null) {

                return currentWeatherCityRepository.save(currentWeatherCityResponse);
            }

        } catch (Exception e) {

            LOG.error("Something went wrong inside getByCityStateCountry");
            LOG.error("{} || {} , caused an issue, it would be resolved soon!", e.getMessage(), e.getClass());
        }

        return currentWeatherCityResponse;
    }
}
