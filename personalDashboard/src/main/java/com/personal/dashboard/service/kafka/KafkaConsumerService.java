package com.personal.dashboard.service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void consumeMessage(String message) {

        System.out.println("Received message: " + message);

    }
    
}
