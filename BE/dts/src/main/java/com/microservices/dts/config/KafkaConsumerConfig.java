package com.microservices.dts.config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
	@Value(value ="${configuration.property.kafka.url}")
	String kafkaUrl;
   @Bean
   public ConsumerFactory<String, ArrayList<Object>> consumerFactory() {
      Map<String, Object> props = new HashMap<>();
      props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaUrl);
      props.put(ConsumerConfig.GROUP_ID_CONFIG, "group-id");
      props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
      props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
      props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, Boolean.FALSE);
      props.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG, "read_committed");
      props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 50);
      props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
      return new DefaultKafkaConsumerFactory<>(props);
   }
   @Bean
   public ConcurrentKafkaListenerContainerFactory<String, ArrayList<Object>> kafkaListenerContainerFactory() {
      ConcurrentKafkaListenerContainerFactory<String, ArrayList<Object>> 
      factory = new ConcurrentKafkaListenerContainerFactory<>();
      factory.setConsumerFactory(consumerFactory());
      factory.setConcurrency(3);
      factory.getContainerProperties().setPollTimeout(3000);
      return factory;
   }
  
   

}