package com.arca.technique.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arca.technique.model.Marchandise;
import com.arca.technique.repository.MarchandiseRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JobRestController {
	Logger log = LoggerFactory.getLogger(JobRestController.class);
	@Autowired
	private  MarchandiseRepository marchandiseRepository;
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;
	
	
/**
 * Lancement du batch
 * @return
 * @throws Exception
 */
	@GetMapping("/loadBatch")
	public BatchStatus load() throws Exception {
		Map<String, JobParameter> parameters = new HashMap<>();
		parameters.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters jobParameters = new JobParameters(parameters);
		JobExecution jobExecution = jobLauncher.run(job, jobParameters);
		while (jobExecution.isRunning()) {
			log.info("...");
		}

		return jobExecution.getStatus();
	

	}

	/**
	 * Recuperation des sources
	 * @return
	 */
	@GetMapping("/marchandises")
	public List<Marchandise> getMarchandises() {
		
		List<Marchandise> liste = marchandiseRepository.findAll();
     
    
		return liste;
	
	}
	
	
}
