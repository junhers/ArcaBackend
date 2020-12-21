package com.arca.technique.batch;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.stereotype.Component;


@Component
public class MarchandiseCountListener implements ChunkListener{

	@Override
	public void beforeChunk(ChunkContext context) {
		
	}
	
	/**
	 * Gestion de la barre de progression
	 */

	@Override
	public void afterChunk(ChunkContext context) {
		
	int count = context.getStepContext().getStepExecution().getReadCount();
		
			
			
	}

	@Override
	public void afterChunkError(ChunkContext context) {
	
	}
	
		
	}




