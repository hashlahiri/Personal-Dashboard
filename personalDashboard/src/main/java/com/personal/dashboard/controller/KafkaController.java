package com.personal.dashboard.controller;

import com.personal.dashboard.service.kafka.KafkaProducerService;
import com.personal.dashboard.utils.APIEndpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = APIEndpoints.KAFKA_API_URL)
public class KafkaController {

    @Autowired
    private KafkaProducerService producerService;

    @PostMapping("/publish")
    public void publishMessage(
            @RequestParam(name = "topic") String topic,
            @RequestParam(name = "message") String message) {

        producerService.sendMessage(topic, message);
    }

}

