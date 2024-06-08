package com.personal.dashboard.validation;

import com.personal.dashboard.domain.enums.ValidationErrorType;
import com.personal.dashboard.domain.mongo.jsonCompare.request.JsonCompareRequest;
import com.personal.dashboard.exception.ValidationError;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonCompareValidator {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(JsonCompareValidator.class);

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Validate json key exists inside another json
     *
     * @param jsonCompareRequest - {@link JsonCompareRequest}
     * @return - {@link List<ValidationError>}
     */
    public static List<ValidationError> validateJsonKeyExistsWithinJson(final JsonCompareRequest jsonCompareRequest) {

        List<ValidationError> validationErrorList = new ArrayList<>();

        // object null
        if (jsonCompareRequest == null) {
            validationErrorList.add(new ValidationError("'jsonCompareRequest object' cannot be Empty",
                    ValidationErrorType.REQUIRED_FIELD_MISSING.getErrorType()));
        } else {

            if(StringUtils.isEmpty(jsonCompareRequest.getPayload())) {
                validationErrorList.add(new ValidationError("'payload' cannot be Empty, contains actual json",
                        ValidationErrorType.REQUIRED_FIELD_MISSING.getErrorType()));
            }

            if(StringUtils.isEmpty(jsonCompareRequest.getParentKey())) {
                validationErrorList.add(new ValidationError("'parentKey' cannot be Empty, it holds the json pointer to search under",
                        ValidationErrorType.REQUIRED_FIELD_MISSING.getErrorType()));
            }

            if(StringUtils.isEmpty(jsonCompareRequest.getChildKey())) {
                validationErrorList.add(new ValidationError("'childKey' cannot be Empty, it holds the json key we are searching",
                        ValidationErrorType.REQUIRED_FIELD_MISSING.getErrorType()));
            }

        }

        return validationErrorList;
    }

}
