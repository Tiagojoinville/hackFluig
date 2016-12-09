package br.com.totvs.fluig.impl;

import java.io.File;

import javax.mail.Folder;

import br.com.totvs.fluig.service.WidgetGenerator;

public class WidgetGeneratorImpl implements WidgetGenerator {

	public String generate(){
		
		String zipFile = "";
		
		String tempFolder = generateFolder("/app/fluig/temp");
		String srcFolder = generateSrcFolder(tempFolder);
		String mainFolder = generateMainFolder(srcFolder);
		
		String javaFolder = generateJavaFolder(mainFolder);
		String resourcesFolder = generateResourceFolder(mainFolder);
		
		String webappFolder = generateWebappFolder(mainFolder);
		String webinfWebappFolder = generateWebinfWebappFolder(mainFolder);
		String resourcesWebappFolder = generateResourcesWebappFolder(mainFolder);
				
		return zipFile;
	}
	
	
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
		return generateFolder(path + "/resource");
	}

	public String generateWebappFolder(String path){
		return generateFolder(path + "/webapp");
	}

}
