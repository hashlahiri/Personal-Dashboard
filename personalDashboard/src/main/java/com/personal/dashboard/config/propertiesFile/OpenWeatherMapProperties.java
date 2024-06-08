package com.personal.dashboard.config.propertiesFile;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Weather API - properties (yml)
 */
@Configuration
@ConfigurationProperties(prefix = "weather")
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class OpenWeatherMapProperties {

    private String apikey;

}
