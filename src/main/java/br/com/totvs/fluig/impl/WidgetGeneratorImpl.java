package br.com.totvs.fluig.impl;

import java.io.File;

import javax.mail.Folder;

import br.com.totvs.fluig.service.FileGenerator;
import br.com.totvs.fluig.service.FolderGenerator;
import br.com.totvs.fluig.service.WidgetGenerator;

public class WidgetGeneratorImpl implements WidgetGenerator {
		
	public String generate(){

		System.out.println("Inicio");

		String nameApp = "totvs_something";
		String packageName = "com.totvs.fluig";
		String zipFile = "";

		/*
		 * FOLDERS
		 */
		FolderGenerator folderGenerator = new FolderGeneratorImpl();
		
		String tempFolder = folderGenerator.generateFolder("/tmp/fluig/temp");
		String srcFolder = folderGenerator.generateSrcFolder(tempFolder);
		String mainFolder = folderGenerator.generateMainFolder(srcFolder);
		
		String javaFolder = folderGenerator.generateJavaFolder(mainFolder);
		String packages = folderGenerator.generatePackagesFolder(javaFolder,packageName);
		
		String resourcesFolder = folderGenerator.generateResourceFolder(mainFolder);
		String resourcesMetainfFolder = folderGenerator.generateResourceMetaInfFolder(resourcesFolder);
		
		
		String webappFolder = folderGenerator.generateWebappFolder(mainFolder);
		String webinfWebappFolder = folderGenerator.generateWebinfWebappFolder(webappFolder);
		String resourcesWebappFolder = folderGenerator.generateResourcesWebappFolder(webappFolder);
		String cssFolder = folderGenerator.generateCssFolder(resourcesWebappFolder);
		String imagesFolder = folderGenerator.generateImagesFolder(resourcesWebappFolder);
		String jsFolder = folderGenerator.generateJsFolder(resourcesWebappFolder);
		
		/*
		 * FILES
		 */
		FileGenerator fileGenerator = new FileGeneratorImpl();
		fileGenerator.createApplication(resourcesFolder, nameApp);
		fileGenerator.createProperties(resourcesFolder, nameApp);
		
		fileGenerator.createEdit(resourcesFolder, nameApp);
		fileGenerator.createView(resourcesFolder, nameApp);
		
		System.out.println("Fim");
		return zipFile;
	}
	
}
