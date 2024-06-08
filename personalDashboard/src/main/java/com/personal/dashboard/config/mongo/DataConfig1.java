package com.personal.dashboard.config.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * MongoDB configuration
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.personal.dashboard.repository")
public class DataConfig1 {

    @Value("${spring.data.mongodb.uri}") // Correct property name
    private String mongodbUri;

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, "personalDashboardApp"); // Use the actual database name
    }

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(mongodbUri); // Spring Boot handles MongoClient creation
    }
}
