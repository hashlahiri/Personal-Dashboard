package com.personal.dashboard.config.mongo;

import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.mongodb.repository")
public class DataConfig1 {

    @Value("${mongodb.datasource.url}")
    private String mongodbUrl;

    @Value("${mongodb.datasource.driver-class-name}")
    private String mongodbDriverClassName;

    @Bean
    public MongoTemplate mongoTemplate() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI(mongodbUrl));
        return new MongoTemplate(mongoClient, "databaseName");
    }
}
