package com.arca.technique.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;



public class MarchandiseCountItemStream implements ItemStream {
	Logger log = LoggerFactory.getLogger(MarchandiseCountItemStream.class);

	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
	
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		  
		
	}

	@Override
	public void close() throws ItemStreamException {
		
	}

}
