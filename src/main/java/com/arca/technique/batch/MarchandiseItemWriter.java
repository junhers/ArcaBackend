package com.arca.technique.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arca.technique.model.Marchandise;
import com.arca.technique.repository.MarchandiseRepository;

@Component
public class MarchandiseItemWriter implements ItemWriter<Marchandise> {
	@Autowired
	private MarchandiseRepository marchandiseRepository;

	@Override
	public void write(List<? extends Marchandise> list) throws Exception {
		marchandiseRepository.saveAll(list);

	}

}
