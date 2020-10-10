package com.iambeginner.spring.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("batch")
public class Job001Controller {

	@Autowired
	@Qualifier("asyncJobLauncher")
	private JobLauncher jobLauncher;
	
	@Autowired
	@Qualifier("job001")
	private Job job001;
	
	@GetMapping("job001")
	public String invokeJob(){
		JobExecution jobExecution = null;
		try {
			JobParameters jobParameters = new JobParametersBuilder().addLong("run.id", System.currentTimeMillis()).toJobParameters();
			jobExecution = jobLauncher.run(job001, jobParameters);
		} catch (JobExecutionAlreadyRunningException e) {
			e.printStackTrace();
		} catch (JobRestartException e) {
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			e.printStackTrace();
		}
		return jobExecution.getJobId()+" - "+jobExecution.getStatus();
	} 
 
}
