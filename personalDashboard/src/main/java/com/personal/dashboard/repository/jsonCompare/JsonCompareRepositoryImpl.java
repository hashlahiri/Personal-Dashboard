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
    
    public String findJsonInsideAnotherJson(JsonCompareRequest jsonCompareRequest) {
        
        String result = null;
        try {
            //validation
            List<ValidationError> validationErrorList = JsonCompareValidator.validateJsonExistsWithinJson(jsonCompareRequest);
            if (!validationErrorList.isEmpty()) {
                LOG.error("Could not find json inside another json due to insufficient data.");
                throw new ValidationException(validationErrorList, ErrorResponseEnum.VALIDATION_ERROR);
            }

            // jsonCompare1 --> parent Json, jsonCompare2 --> child Json
            result = jsonCompareUtility.jsonExistsWithinAnotherJson(jsonCompareRequest.getJsonCompare1(), jsonCompareRequest.getJsonCompare2());

            LOG.info("Successfully processed json comparison");
            
        } catch (Exception e) {
            
            LOG.error("Something went wrong inside 'findJsonInsideAnotherJson'");
            LOG.error("{} | {}", e.getMessage(), e.getClass());
        }
        
        return result;
    }
}
