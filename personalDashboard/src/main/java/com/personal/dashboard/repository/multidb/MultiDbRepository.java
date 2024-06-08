package com.personal.dashboard.repository.multidb;

import com.personal.dashboard.domain.multidb.MultiDb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface MultiDbRepository extends MongoRepository<MultiDb, Serializable>, MultiDbRepositoryCustom {


}
