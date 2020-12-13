package com.arca.technique.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arca.technique.model.Marchandise;


public interface MarchandiseRepository extends JpaRepository<Marchandise, Long> {

}
