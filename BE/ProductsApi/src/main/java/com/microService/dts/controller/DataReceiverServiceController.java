package com.microservice.dts.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.dts.pojo.MeterReadData;
import com.microservice.dts.resource.DataReceiverServiceProducer;

@RestController
public class DataReceiverServiceController {
	@Value("${server.port}")
	private int port;
	@Autowired
	private DataReceiverServiceProducer producer;
	private AtomicLong idGenerator;
	
	public DataReceiverServiceController() {
		idGenerator = new AtomicLong(0);
	}
	
	@PostMapping(path="/api",produces="application/json",consumes="application/json")
	@Transactional("kafkaTransactionManager")
	public String produce(@RequestBody MeterReadData obj)
	{
		obj.setId(idGenerator.addAndGet(1));
		System.out.println(obj);
		producer.sendMessage(obj);
		return obj.toString();
	}
	@GetMapping("/getApi")
	public String getProduct()
	{
		System.out.println("Inside Get- Port="+port);
		return "Product from "+port;
	}

}
