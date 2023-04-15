package com.personal.dashboard.repository.currentWeather;

import com.personal.dashboard.domain.enums.ErrorResponseEnum;
import com.personal.dashboard.domain.openWeatherMap.CurrentWeatherRequest;
import com.personal.dashboard.domain.openWeatherMap.CurrentWeatherResponse;
import com.personal.dashboard.exception.ValidationError;
import com.personal.dashboard.exception.ValidationException;
import com.personal.dashboard.utils.OpenWeatherMapUtility;
import com.personal.dashboard.validation.CurrentWeatherValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;

import java.util.List;

public class CurrentWeatherRepositoryImpl implements CurrentWeatherRepositoryCustom {

    @Autowired
    private CurrentWeatherRepository currentWeatherRepository;

    @Autowired
    private OpenWeatherMapUtility openWeatherMapUtility;

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(CurrentWeatherRepositoryImpl.class);

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public CurrentWeatherResponse getByLatLong(CurrentWeatherRequest currentWeatherRequest) {

        //Validation
        List<ValidationError> validationErrorList = CurrentWeatherValidator.validateCurrentWeatherByLatLongRequest(currentWeatherRequest);
        if (!validationErrorList.isEmpty()) {
            LOG.error("Could not get current weather due to insufficient data.");
            throw new ValidationException(validationErrorList, ErrorResponseEnum.VALIDATION_ERROR);
        }

        // current weather response object
        CurrentWeatherResponse currentWeatherResponse = CurrentWeatherResponse.builder().build();
        try {
            // 3rd party API invoked
            currentWeatherResponse = openWeatherMapUtility.invokeCurrentWeatherResponseReport(currentWeatherRequest);

            // if response is successful
            if(currentWeatherResponse != null) {

                return currentWeatherRepository.save(currentWeatherResponse);
            }

        } catch (Exception e) {

            LOG.error("Something went wrong inside getByLatLong!");
            LOG.error("{} || {} , caused an issue, it would be resolved soon!", e.getMessage(), e.getClass());
        }

        return currentWeatherResponse;
    }


}
