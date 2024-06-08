package com.personal.dashboard.config.prop;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application-dev.yml")
@Data
public class OpenWeatherMapProperties {

    @Value("${weather.apikey}")
    private String apikey;

}
