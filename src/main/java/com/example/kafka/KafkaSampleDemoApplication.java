package com.example.kafka;

import com.example.kafka.producer.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalTime;

@SpringBootApplication
public class KafkaSampleDemoApplication {

    static KafkaProducerService producerService;

    @Autowired
    public KafkaSampleDemoApplication(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaSampleDemoApplication.class, args);

        producerService.send("topic-sample", "A messaged generated at " + LocalTime.now());
    }
}
