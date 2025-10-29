package com.personal.dashboard.controller;

import com.personal.dashboard.domain.mongo.jsonCompare.request.JsonCompareRequest;
import com.personal.dashboard.domain.mongo.jsonCompare.response.JsonCompareResponse;
import com.personal.dashboard.service.jsonCompare.JsonCompareService;
import com.personal.dashboard.utils.APIEndpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * JSON compare controller
 */
@RestController
@RequestMapping(value = APIEndpoints.JSON_COMPARE_API_URL)
public class JsonCompareController {

    @Autowired
    private JsonCompareService jsonCompareService;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * If given json is available inside parent json
     *
     * @param jsonCompareRequest - {@link JsonCompareRequest}
     * @return - {@link String}
     */
    @RequestMapping(value = "/ifKeyExists", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonCompareResponse> ifKeyExistsWithinAnotherJsonEndpoint(
            @RequestBody JsonCompareRequest jsonCompareRequest) {

        JsonCompareResponse response = jsonCompareService.
                findJsonKeyInsideAnotherJsonService(jsonCompareRequest);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
