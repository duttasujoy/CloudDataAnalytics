package com.microservice.loadbalancer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@PropertySource("classpath:application.properties")
public class Controller {
	@Autowired
	RestTemplate template;
	@Value(value = "${configuration.property.url}")
	private String url ;
	
	@GetMapping("callProduct")
	public String callApi(){
		return template.getForObject(url, String.class);
	}
	@PostMapping(path="/sendToProduct",produces="application/json",consumes="application/json")
	public ResponseEntity<String> sendToProduct(@RequestBody Object obj, @RequestHeader HttpHeaders headers){
		HttpEntity<Object> request = new HttpEntity<>(obj, headers);
		return template.exchange(url, HttpMethod.POST, request, String.class,new String());

	}

}
