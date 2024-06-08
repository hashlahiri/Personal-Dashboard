package com.personal.dashboard.service.multidb;

import com.personal.dashboard.domain.mongo.multidb.MultiDb;
import com.personal.dashboard.repository.multidb.MultiDbRepository;
import com.personal.dashboard.repository.multidb.request.MultiDbRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiDbService {

    @Autowired
    private MultiDbRepository multiDbRepository;

    ///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Save into multiple DB
     *
     * @param request - {@link MultiDbRequest}
     * @return - {@link MultiDb}
     */
    public MultiDb saveIntoMultiDbService(MultiDbRequest request) {

        return multiDbRepository.saveIntoMultiDb(request);
    }

}
