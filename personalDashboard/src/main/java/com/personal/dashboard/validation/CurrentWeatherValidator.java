package com.personal.dashboard.validation;

import com.personal.dashboard.domain.enums.ValidationErrorType;
import com.personal.dashboard.domain.openWeatherMap.CurrentWeatherRequest;
import com.personal.dashboard.exception.ValidationError;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CurrentWeatherValidator {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(CurrentWeatherValidator.class);

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Validate current weather by latitude and longitude request
     *
     * @param currentWeatherRequest - {@link CurrentWeatherRequest}
     * @return - {@link List<ValidationError>}
     */
    public static List<ValidationError> validateCurrentWeatherByLatLongRequest(final CurrentWeatherRequest currentWeatherRequest) {

        List<ValidationError> validationErrorList = new ArrayList<>();

        // Object null check
        if (currentWeatherRequest == null) {
            validationErrorList.add(new ValidationError("'CurrentWeatherRequest object' cannot be Empty",
                    ValidationErrorType.REQUIRED_FIELD_MISSING.getErrorType()));
        }

        // lat null check
        if (StringUtils.isEmpty(currentWeatherRequest.getLatitude())) {
            validationErrorList.add(new ValidationError("'lat' cannot be Empty",
                    ValidationErrorType.REQUIRED_FIELD_MISSING.getErrorType()));
        }

        // lon null check
        if (StringUtils.isEmpty(currentWeatherRequest.getLongitude())) {
            validationErrorList.add(new ValidationError("'lon' cannot be Empty",
                    ValidationErrorType.REQUIRED_FIELD_MISSING.getErrorType()));
        }

        return validationErrorList;

    }
}
