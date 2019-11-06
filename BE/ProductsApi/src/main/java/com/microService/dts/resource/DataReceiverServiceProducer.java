package com.microservice.dts.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataReceiverServiceProducer {
	
	@Value(value ="${configuration.property.kafka.topic}")
	String topic;
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	 
	public void sendMessage(Object msg) {
	   System.out.println(kafkaTemplate.send(topic, msg));
	}

}
