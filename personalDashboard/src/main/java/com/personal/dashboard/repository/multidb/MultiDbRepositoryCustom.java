package com.personal.dashboard.repository.multidb;

import com.personal.dashboard.domain.multidb.MultiDb;
import com.personal.dashboard.repository.multidb.request.MultiDbRequest;

public interface MultiDbRepositoryCustom {

    MultiDb saveIntoMultiDb(MultiDbRequest request);

}
