package com.arca.technique.batch;

import org.springframework.batch.item.ItemProcessor;

import com.arca.technique.model.Marchandise;

public class MarchandiseItemProcessor implements ItemProcessor< Marchandise,  Marchandise> {


	@Override
	public Marchandise process(Marchandise marchandise) throws Exception {
		return marchandise;
	}

}
