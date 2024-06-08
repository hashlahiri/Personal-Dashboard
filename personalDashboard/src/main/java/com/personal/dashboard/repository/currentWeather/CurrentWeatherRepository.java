package com.personal.dashboard.repository.currentWeather;

import com.personal.dashboard.domain.mongo.openWeatherMap.CurrentWeatherResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CurrentWeatherRepository extends MongoRepository<CurrentWeatherResponse, Serializable>,
        CurrentWeatherRepositoryCustom {


}
