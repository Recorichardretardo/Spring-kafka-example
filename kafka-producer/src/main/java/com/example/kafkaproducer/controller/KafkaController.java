package com.example.kafkaproducer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaproducer.model.Message;
import com.example.kafkaproducer.service.KafkaProducerService;

@RestController
public class KafkaController {

    @Autowired
    KafkaProducerService kafkaProducerService;

    @PostMapping("publish")
    public String publishMessage(@RequestBody Message msg){
    	String res = "";
    	try {
    		kafkaProducerService.sendMessage(msg);
    		res = "message sent";
    	}catch(Exception e) {
    		res = e.getMessage().toString();
    		System.out.println(e.getMessage());
    		e.printStackTrace();
    	}
        return res;
    }
}