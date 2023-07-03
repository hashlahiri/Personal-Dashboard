package com.personal.dashboard.repository.jsonCompare;

import com.personal.dashboard.domain.enums.ErrorResponseEnum;
import com.personal.dashboard.domain.jsonCompare.JsonCompareRequest;
import com.personal.dashboard.exception.ValidationError;
import com.personal.dashboard.exception.ValidationException;
import com.personal.dashboard.utils.JsonCompareUtility;
import com.personal.dashboard.validation.JsonCompareValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JsonCompareRepositoryImpl {

    @Autowired
    private JsonCompareUtility jsonCompareUtility;

    private static final Logger LOG = LoggerFactory.getLogger(JsonCompareRepositoryImpl.class);
            
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Json matching is by default case-sensitive and uses regular expressions
     *
     * @param jsonCompareRequest - {@link JsonCompareRequest}
     * @return - {@link String}
     */
    public String findJsonKeyInsideAnotherJsonService(JsonCompareRequest jsonCompareRequest) {
        
        String result = null;
        try {
            //validation
            List<ValidationError> validationErrorList = JsonCompareValidator.validateJsonKeyExistsWithinJson(jsonCompareRequest);
            if (!validationErrorList.isEmpty()) {
                LOG.error("Could not find json inside another json due to insufficient data.");
                throw new ValidationException(validationErrorList, ErrorResponseEnum.VALIDATION_ERROR);
            }

            // jsonCompare1 --> Json, jsonCompare2 --> Key we are searching for
            result = jsonCompareUtility.jsonKeyExistsWithinJson(jsonCompareRequest.getJsonCompare1(), jsonCompareRequest.getJsonCompare2(),
                    jsonCompareRequest.getJsonCompare3());

            LOG.info("Successfully processed json comparison");
            
        } catch (Exception e) {
            
            LOG.error("Something went wrong inside 'findJsonInsideAnotherJson'");
            LOG.error("{} | {}", e.getMessage(), e.getClass());
        }
        
        return result;
    }

}
