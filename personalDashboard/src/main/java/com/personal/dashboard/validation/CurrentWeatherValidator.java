package com.personal.dashboard.validation;

import com.personal.dashboard.domain.enums.ValidationErrorType;
import com.personal.dashboard.domain.openWeatherMap.CurrentWeatherRequest;
import com.personal.dashboard.exception.ValidationError;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;

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

    /**
     * Validate current weather by city, stateCode, and country code
     *
     * @param city - String city
     * @param stateCode - String stateCode
     * @param countryCode - String countryCode
     * @return - {@link  List<ValidationError>}
     */
    public static List<ValidationError> validateCurrentWeatherByCityStateCountry(final String city, final String stateCode, final String countryCode) {

        List<ValidationError> validationErrorList = new ArrayList<>();

        // 'city'
        if (StringUtils.isEmpty(city)) {

            validationErrorList.add(new ValidationError("'city' name cannot be empty",
                    ValidationErrorType.REQUIRED_FIELD_MISSING.getErrorType()));
        }

        // length of stateCode MUST be 2
        if(!StringUtils.isEmpty(stateCode) && StringUtils.length(stateCode) != 2) {

            validationErrorList.add(new ValidationError("'stateCode' must be of two characters only",
                    ValidationErrorType.REQUIRED_FIELD_MISSING.getErrorType()));
        }

        // length of countryCode MUST be 2
        if(!StringUtils.isEmpty(countryCode) && StringUtils.length(countryCode) != 2) {

            validationErrorList.add(new ValidationError("'countryCode' must be of two characters only",
                    ValidationErrorType.REQUIRED_FIELD_MISSING.getErrorType()));
        }

        // if 'stateCode' is present, 'countryCode' must also be present
        if(!StringUtils.isEmpty(stateCode) && StringUtils.isEmpty(countryCode)) {

            validationErrorList.add(new ValidationError("Provided 'stateCode' must include 'countryCode' as well",
                    ValidationErrorType.REQUIRED_FIELD_MISSING.getErrorType()));
        }

        return validationErrorList;
    }
}
