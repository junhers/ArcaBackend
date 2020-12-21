package com.arca.technique.batch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

import com.arca.technique.model.JobProgressMessage;
import com.arca.technique.model.Marchandise;

/**
 * Gestion de la barre de progression
 */
@Component
public class MarchandiseJobListener implements ItemWriteListener<Marchandise>, JobExecutionListener {
	private static Logger log = LoggerFactory.getLogger(MarchandiseJobListener.class);

	private JobExecution jobExecution;
	private String fileName;
	private AtomicInteger runningWriteCount = new AtomicInteger(0);

	private int count;

	static final String INPUT_FILE_NAME = "src/main/resources/data2.txt";

	@Override
	public void afterWrite(List<? extends Marchandise> items) {

		double runningWriteCount = this.runningWriteCount.addAndGet(items.size());
		JobProgressMessage jobProgressMessage = new JobProgressMessage();
		jobProgressMessage.setStatus("RUNNING");
		jobProgressMessage.setCount(runningWriteCount);
		jobProgressMessage.setFileName(fileName);

	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
		this.jobExecution = jobExecution;
		String absoluteFilePath = jobExecution.getJobParameters().getString("absoluteFileName");
		try {
			count = countLines(absoluteFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		JobProgressMessage jobProgressMessage = new JobProgressMessage();
		log.info("count: ", jobProgressMessage.getCount());

	}

	@Override
	public void beforeWrite(List<? extends Marchandise> items) {

	}

	@Override
	public void onWriteError(Exception exception, List<? extends Marchandise> items) {

	}

	public static int countLines(String fileName) throws IOException {
		int countLines = 0;

		@SuppressWarnings("resource")
		Stream<String> fileStream = Files.lines(Paths.get(fileName));
		countLines = (int) fileStream.count();

		return countLines;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
