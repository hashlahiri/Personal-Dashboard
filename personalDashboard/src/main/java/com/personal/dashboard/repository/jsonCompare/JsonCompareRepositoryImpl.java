package com.personal.dashboard.repository.jsonCompare;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.dashboard.domain.enums.ErrorResponseEnum;
import com.personal.dashboard.domain.mongo.jsonCompare.request.JsonCompareRequest;
import com.personal.dashboard.domain.mongo.jsonCompare.response.JsonCompareResponse;
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

    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger LOG = LoggerFactory.getLogger(JsonCompareRepositoryImpl.class);
            
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Json matching is by default case-sensitive and uses regular expressions
     *
     * @param jsonCompareRequest - {@link JsonCompareRequest}
     * @return - {@link String}
     */
    public JsonCompareResponse findJsonKeyInsideAnotherJsonService(JsonCompareRequest jsonCompareRequest) {

        /** response object */
        JsonCompareResponse response = JsonCompareResponse.builder()
                .exists(false) // exists
                .build();
        try {
            //validation
            List<ValidationError> validationErrorList = JsonCompareValidator.validateJsonKeyExistsWithinJson(jsonCompareRequest);
            if (!validationErrorList.isEmpty()) {
                LOG.error("Could not find json inside another json due to insufficient data.");
                throw new ValidationException(validationErrorList, ErrorResponseEnum.VALIDATION_ERROR);
            }

            JsonNode tree = objectMapper.readTree(jsonCompareRequest.getPayload());

            // parentKey --> Json, childKey --> Key we are searching for
            boolean isExists = jsonCompareUtility.jsonKeyExistsWithinJson(
                    tree,
                    jsonCompareRequest.getParentKey(),
                    jsonCompareRequest.getChildKey());

            response = response.toBuilder()
                    .exists(isExists) // exists
                    .build();

            LOG.info("Successfully processed json comparison");

        } catch (JsonProcessingException e) {
            throw new ValidationException(
                    List.of(new ValidationError("payload", "Invalid JSON")),
                    ErrorResponseEnum.VALIDATION_ERROR);
        } catch (Exception e) {

            LOG.error("Something went wrong inside 'findJsonInsideAnotherJson'");
            LOG.error("{} | {}", e.getMessage(), e.getClass());
        }

        return response;
    }

}
