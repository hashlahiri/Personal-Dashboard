package com.personal.dashboard.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger configuration
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //the main swagger configuration
    @Bean
    public Docket swaggerConfiguration() {
        // return a prepared Docket instance
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.personal.dashboard.controller"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {

        return new ApiInfoBuilder().title("Personal Dashboard").license("MIT License").licenseUrl("https://swagger.io/license/")
                .description("Personal Dashboard Application filled with OPEN Restful API data for <b>Personal UI data display</b> <i>by Chanakya Lahiri</i>.")
                .termsOfServiceUrl("http://www.google.com")
                .contact(new Contact("Chanakya Lahiri", "http://www.google.com",
                        "helloclahiri@gmail.com"))
                .version("1.0").build();
    }
}