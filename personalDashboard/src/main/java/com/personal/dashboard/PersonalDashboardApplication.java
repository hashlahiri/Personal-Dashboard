package com.personal.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
