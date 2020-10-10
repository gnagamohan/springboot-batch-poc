package com.iambeginner.spring;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableBatchProcessing
@ImportResource(locations={
		"classpath:batch-config/job001-master-context.xml"
		})
public class MasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterApplication.class, args);
	}
}
