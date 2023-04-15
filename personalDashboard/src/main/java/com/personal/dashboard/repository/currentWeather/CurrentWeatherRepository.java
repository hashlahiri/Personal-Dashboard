package com.personal.dashboard.repository.currentWeather;

import com.personal.dashboard.domain.openWeatherMap.CurrentWeatherResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentWeatherRepository extends MongoRepository<CurrentWeatherResponse, String>, CurrentWeatherRepositoryCustom {


}
