package br.com.totvs.fluig.service;

public interface FileGenerator {

	public void createFile(String path, String nameFile, String content);
	
	public void createApplication(String path);
	
	public void createProperties(String path);
}
