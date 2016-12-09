package br.com.totvs.fluig.service;

import java.io.File;

public interface WidgetGenerator {

	public String generate();
	
	public String generateFolder(String path);
	
	public String generateSrcFolder(String path);
	
	public String generateMainFolder(String path);
	
	public String generateJavaFolder(String path);

	public String generateResourceFolder(String path);
	
	public String generateWebappFolder(String path);
	
}
