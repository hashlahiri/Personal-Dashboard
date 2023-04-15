package com.personal.dashboard;

import com.personal.dashboard.config.propertiesFile.OpenWeatherMapProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableMongoAuditing
@EnableSwagger2
@EnableConfigurationProperties
public class PersonalDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalDashboardApplication.class, args);
	}

}
