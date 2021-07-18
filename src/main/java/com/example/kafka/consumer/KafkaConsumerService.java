package com.example.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@KafkaListener(topics = {"topic-sample"}, groupId = "sample-group")
public class KafkaConsumerService {

    @KafkaHandler
    void handleString(String message){
        log.info("KafkaHandler[String] {}", message);
    }

    @KafkaHandler(isDefault = true)
    void handleObject(Object message){
        log.info("KafkaHandler[Default] {}", message);
    }
}
