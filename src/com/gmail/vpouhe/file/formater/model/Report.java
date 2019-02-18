package com.gmail.vpouhe.file.formater.model;

import java.util.List;

public class Report {
	private String inputFile;
	private List<Reference> references;

	public Report() {
		super();
	}

	public Report(String inputFile, List<Reference> references) {
		super();
		this.inputFile = inputFile;
		this.references = references;
	}

	public String getInputFile() {
		return inputFile;
	}

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public List<Reference> getReferences() {
		return references;
	}

	public void setReferences(List<Reference> references) {
		this.references = references;
	}

	@Override
	public String toString() {
		return "Report [inputFile=" + inputFile + ", references=" + references + "]";
	}

}
