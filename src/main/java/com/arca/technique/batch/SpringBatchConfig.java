package com.arca.technique.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.arca.technique.model.Marchandise;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private ItemReader<Marchandise> itemReader;

	@Autowired
	private ItemWriter<Marchandise> itemWriter;

	@Bean
	public Job job(Step step1) {
		return jobBuilderFactory.get("Marchandise").incrementer(new RunIdIncrementer()).start(step1())
				.build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("première étape: chargement de fichier").<Marchandise, Marchandise>chunk(1)
				.reader(itemReader).writer(itemWriter)
				.listener(listener()).build();

	}

	@Bean
	public MarchandiseCountListener listener() {

		return new MarchandiseCountListener();
	}

	@Bean
	public FlatFileItemReader<Marchandise> reader(@Value("${inputFile}") Resource resource) {
		return new FlatFileItemReaderBuilder<Marchandise>().name("marchandiseItemReader").resource(resource)
				.delimited().names(new String[] { "date", "valeur", "pays" })
				.fieldSetMapper(new BeanWrapperFieldSetMapper<Marchandise>() {
					{
						setTargetType(Marchandise.class);
					}
				}).build();
	}

}