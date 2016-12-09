package br.com.totvs.fluig.service;

public interface FolderGenerator {

	public String generateFolder(String path);
	
	public String generateSrcFolder(String path);
	
	public String generateMainFolder(String path);
	
	public String generateJavaFolder(String path);

	public String generateResourceFolder(String path);
	
	public String generateWebappFolder(String path);
		
	public String generateWebinfWebappFolder(String path);
	
	public String generateResourcesWebappFolder(String path);
	
	public String generateCssFolder(String path);
	
	public String generateImagesFolder(String path);
	
	public String generateJsFolder(String path);
	
	public String generateResourceMetaInfFolder(String path);
	
	public String generatePackagesFolder(String path, String packageName);
	
}
