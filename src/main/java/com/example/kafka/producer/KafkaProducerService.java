package com.example.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaProducerService {

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, String message){
        this.kafkaTemplate.send(topic, message);
    }

    public void send(String topic, String message, ListenableFutureCallback<SendResult<String, String>> callback){
        ListenableFuture<SendResult<String, String>> listenableFuture = this.kafkaTemplate.send(topic, message);
        listenableFuture.addCallback(callback);
    }
}
