package com.iambeginner.spring.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.iambeginner.spring.serializer.CustomDeserializer;
import com.iambeginner.spring.serializer.CustomSerializer;

@Configuration
public class KafkaConfig {
	
	@Value("${batch.kafka.bootstrap-servers}")
	private String BOOTSTRAP_SERVERS;
	
	@Value("${batch.kafka.producer.acks}")
	private String ACKS;
	
	@Value("${batch.kafka.consumer.auto-offset-reset}")
	private String AUTO_OFFSET_RESET;
	
	@Bean
	public ProducerFactory<String, Object> batchProducerFactory(){
		Map<String, Object> properties = new HashMap<>();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CustomSerializer.class.getName());
		properties.put(ProducerConfig.ACKS_CONFIG, ACKS); //"0","1","all"
		return new DefaultKafkaProducerFactory<String, Object>(properties);
	}
	
	@Bean
	public KafkaTemplate<String, Object> batchKafkaTemplate(){
		return new KafkaTemplate<String, Object>(batchProducerFactory());
	}
	
	public ConsumerFactory<String, Object> batchConsumerFactory(String groupName){
		Map<String, Object> properties = new HashMap<>();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, CustomDeserializer.class.getName());
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupName);
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, AUTO_OFFSET_RESET);
		return new DefaultKafkaConsumerFactory<String, Object>(properties);
	}
	
}
