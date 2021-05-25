package com.example.kafkaproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.kafkaproducer.model.Message;



@Service
public class KafkaProducerService {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(Message msg){
    	kafkaTemplate.send("message-topic", msg.getMessage());
    }

}