package com.personal.dashboard.controller;

import com.personal.dashboard.domain.multidb.MultiDb;
import com.personal.dashboard.repository.multidb.request.MultiDbRequest;
import com.personal.dashboard.service.multidb.MultiDbService;
import com.personal.dashboard.utils.APIEndpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Multi DB controller
 */
@RestController
@RequestMapping(value = APIEndpoints.MULTI_DB_API_URL)
public class MultiDbController {

    @Autowired
    private MultiDbService multiDbService;

    ////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Save this information into muiltiple databases
     *
     * @param request - {@link MultiDbRequest}
     * @return - {@link MultiDb}
     */
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MultiDb> saveIntoMultipleDatabasesEndpoint(
            @RequestBody MultiDbRequest request) {

        MultiDb response = multiDbService.saveIntoMultiDbService(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }




}
