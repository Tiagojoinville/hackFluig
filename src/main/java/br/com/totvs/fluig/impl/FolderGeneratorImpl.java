package br.com.totvs.fluig.impl;

import java.io.File;

import br.com.totvs.fluig.service.FolderGenerator;

public class FolderGeneratorImpl implements FolderGenerator{
	
	public String generateFolder(String folder){
		
		File file = new File(folder);
		
		if(!file.exists()){
			file.mkdir();
		}
		
		return folder;
	}
		
	public String generateSrcFolder(String path){
		return generateFolder(path + "/src");		
	}
	
	public String generateMainFolder(String path){
		return generateFolder(path + "/main");
	}
	
	public String generateJavaFolder(String path){
		return generateFolder(path + "/java");
	}

	public String generateResourceFolder(String path){
		return generateFolder(path + "/resources");
	}

	public String generateWebappFolder(String path){
		return generateFolder(path + "/webapp");
	}
	
	public String generateWebinfWebappFolder(String path){
		return generateFolder(path + "/WEB-INF");
	}
	
	public String generateResourcesWebappFolder(String path){
		return generateFolder(path + "/resources");
	}
	
	public String generateCssFolder(String path){
		return generateFolder(path + "/css");
	}
	
	public String generateImagesFolder(String path){
		return generateFolder(path + "/images");
	}
	
	public String generateJsFolder(String path){
		return generateFolder(path + "/js");
	}
	
	public String generateResourceMetaInfFolder(String path){
		return generateFolder(path + "META-INF");
	}
	
	public String generatePackagesFolder(String path, String packageName){
		
		String packagesFolder = "";
		String[] eachPackage = packageName.split(".");
		
		for (String folder : eachPackage) {
			packagesFolder = generateFolder(path + folder);
			
		}
		
		return packagesFolder;
	}


}
