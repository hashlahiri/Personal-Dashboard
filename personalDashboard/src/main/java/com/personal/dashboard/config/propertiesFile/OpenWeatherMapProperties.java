package com.personal.dashboard.config.propertiesFile;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "weather")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OpenWeatherMapProperties {

    private String apikey;

}
