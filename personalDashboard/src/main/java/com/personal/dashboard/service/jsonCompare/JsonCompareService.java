package com.personal.dashboard.service.jsonCompare;

import com.personal.dashboard.domain.jsonCompare.JsonCompareRequest;
import com.personal.dashboard.repository.jsonCompare.JsonCompareRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsonCompareService {

    @Autowired
    private JsonCompareRepositoryImpl jsonCompareRepository;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    public String findJsonKeyInsideAnotherJsonService(JsonCompareRequest jsonCompareRequest) {

        return jsonCompareRepository.findJsonKeyInsideAnotherJsonService(jsonCompareRequest);
    }

}
