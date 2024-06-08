package com.personal.dashboard.repository.currentWeatherCity;

import com.personal.dashboard.domain.mongo.openWeatherMap.CurrentWeatherCityResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CurrentWeatherCityRepository extends MongoRepository<CurrentWeatherCityResponse, Serializable>,
        CurrentWeatherCityRepositoryCustom {


}
