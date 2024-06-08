package com.personal.dashboard.repository.multidb;

import com.personal.dashboard.domain.multidb.MultiDb;
import com.personal.dashboard.repository.multidb.request.MultiDbRequest;
import org.springframework.beans.factory.annotation.Autowired;

public class MultiDbRepositoryImpl implements MultiDbRepositoryCustom {

    @Autowired
    private MultiDbRepository multiDbRepository;

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(MultiDbRepositoryImpl.class);

    /////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public MultiDb saveIntoMultiDb(MultiDbRequest request) {

        MultiDb multiDbToSave = null;
        try {
            /** Create object to save */
            multiDbToSave = MultiDb.builder()
                    .name(request.getName()) // name
                    .build();

            /** enter same data into multiple DB */

            /** Save into MONGODB */
            multiDbToSave = multiDbRepository.save(multiDbToSave);

            /** Save into Postgresql */

            /** Save into MySQL */

        } catch (Exception e) {

            LOG.error("Something went wrong inside 'saveIntoMultiDB'");
            LOG.error("{} | {}", e.getMessage(), e.getClass());
        }
        return multiDbToSave;
    }

}
