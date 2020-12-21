package com.arca.technique.model;


/**
 * Gestion de la barre de progression
 * @author antoi
 *
 */
public class JobProgressMessage {
	private String status;
	private String fileName;
	private double count;
	private double percentageComplete;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}

	public double getPercentageComplete() {
		return percentageComplete;
	}

	public void setPercentageComplete(double percentageComplete) {
		this.percentageComplete = percentageComplete;
	}

}
