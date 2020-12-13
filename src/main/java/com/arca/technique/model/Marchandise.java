package com.arca.technique.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
	public class Marchandise implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 368925724680978557L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String date;
	
	private Long valeur;
	
	private String pays;
	
	public Marchandise() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getValeur() {
		return valeur;
	}

	public void setValeur(Long valeur) {
		this.valeur = valeur;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
	
	}


