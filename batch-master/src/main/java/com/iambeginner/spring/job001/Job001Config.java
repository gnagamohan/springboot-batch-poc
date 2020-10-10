package com.iambeginner.spring.job001;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.config.ContainerProperties;

import com.iambeginner.spring.config.KafkaConfig;

@Configuration
public class Job001Config {
	
	@Value("${batch.job.job001.reply.topic}")
	private String job001ReplyTopicName;
	
	@Value("${batch.job.job001.reply.group}")
	private String job001KafkaGroupName;
	
	@Value("${batch.job.job001.concurrency}")
	private int job001Concurrency;
	
	@Autowired
	private KafkaConfig kafkaConfig;
	
	@Bean
	public ConcurrentMessageListenerContainer<String, Object> job001ConcurrentMessageListenerContainer(){
		ContainerProperties containerProperties = new ContainerProperties(job001ReplyTopicName);
		ConcurrentMessageListenerContainer<String, Object> concurrentMessageListenerContainer = new ConcurrentMessageListenerContainer<>(kafkaConfig.batchConsumerFactory(job001KafkaGroupName), containerProperties);
		concurrentMessageListenerContainer.setConcurrency(job001Concurrency);
		return concurrentMessageListenerContainer;
	}
}
