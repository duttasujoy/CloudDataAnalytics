package com.microservice.dts.config;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.kafka.transaction.KafkaTransactionManager;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

@Configuration

public class KafkaProducerConfig {
	@Value(value ="${configuration.property.kafka.url}")
	String kafkaUrl;
	@Bean
	public ProducerFactory<String, Object> producerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		System.out.println("kafkaUrl:"+kafkaUrl);
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaUrl);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		configProps.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, "Transaction");
		DefaultKafkaProducerFactory<String, Object> d =new DefaultKafkaProducerFactory<>(configProps);
		d.setTransactionIdPrefix("Transaction");
		return d;
	}
	@Bean
	public KafkaTemplate<String, Object> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	@Bean(name = "kafkaTransactionManager")
	public KafkaTransactionManager kafkaTransactionManager() {
		KafkaTransactionManager ktm = new KafkaTransactionManager(producerFactory());;
		ktm.setTransactionSynchronization(AbstractPlatformTransactionManager.SYNCHRONIZATION_ON_ACTUAL_TRANSACTION);
		return ktm;
	}
}