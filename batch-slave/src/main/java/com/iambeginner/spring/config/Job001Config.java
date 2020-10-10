package com.iambeginner.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.config.ContainerProperties;

@Configuration
public class Job001Config {
	
	@Value("${batch.job.job001.request.topic}")
	private String job001RequestTopicName;
	
	@Value("${batch.job.job001.request.group}")
	private String job001RequestGroupName;
	
	@Value("${batch.job.job001.concurrency}")
	private int job001Concurrency;
	
	@Autowired
	private KafkaConfig kafkaConfig;
	
	@Bean
	public ConcurrentMessageListenerContainer<String, Object> job001ConcurrentMessageListenerContainer(){
		ContainerProperties containerProperties = new ContainerProperties(job001RequestTopicName);
		ConcurrentMessageListenerContainer<String, Object> concurrentMessageListenerContainer = new ConcurrentMessageListenerContainer<>(kafkaConfig.batchConsumerFactory(job001RequestGroupName), containerProperties);
		concurrentMessageListenerContainer.setConcurrency(job001Concurrency);
		return concurrentMessageListenerContainer;
	}
}
