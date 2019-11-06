package com.microservices.dts.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.microservice.dts.pojo.MeterReadData;
import com.microservices.dts.service.DateTransmissionService;

@Component
public class KafkaConsumer {
	@Value(value ="${configuration.property.kafka.topic}")
	String topic;
	@Autowired
	private DateTransmissionService service;
	@KafkaListener(topics = "MeterReadTopic", groupId = "group-id")
	public void listen(MeterReadData data)
	{
		System.out.println("In consumer"+Thread.currentThread().getName()+data);
		service.transfer(data);
	}
	
}
