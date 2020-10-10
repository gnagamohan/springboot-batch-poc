package com.iambeginner.spring.config;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
public class JobConfig {
	
	@Bean
	public JobLauncher asyncJobLauncher(JobRepository jobRepository) {
	    SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
	    jobLauncher.setJobRepository(jobRepository);
	    jobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());
	    return jobLauncher;
	}
	
}
