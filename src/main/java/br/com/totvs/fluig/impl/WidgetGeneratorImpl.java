package br.com.totvs.fluig.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Folder;


import br.com.totvs.fluig.Model.ArtefatosNexus;
import br.com.totvs.fluig.service.FileGenerator;
import br.com.totvs.fluig.service.FolderGenerator;
import br.com.totvs.fluig.service.WidgetGenerator;

public class WidgetGeneratorImpl implements WidgetGenerator {
		
	public String generate(String nameApp, String packageName,String versionId, String dependencies){

		String zipFile = "";
		
		System.out.println("Inicio");




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
		fileGenerator.createWebXml(webinfWebappFolder);
		
		fileGenerator.createEdit(resourcesFolder, nameApp);
		fileGenerator.createView(resourcesFolder, nameApp);
		
	 	/*
		 * POM
		 */
		List<ArtefatosNexus> lstArtefatos =  getArtefatos();
		fileGenerator.createPom(tempFolder, nameApp,packageName,versionId, lstArtefatos);

		
		System.out.println("Fim");
		return zipFile;
	}

	public List<ArtefatosNexus> getArtefatos(){
		List<ArtefatosNexus> lstArtefatosNexus = new ArrayList<>();
		ArtefatosNexus artefatosNexus = new ArtefatosNexus();
		artefatosNexus.setGroupId("org.json");
		artefatosNexus.setArtefato("json");
		artefatosNexus.setVersion("20160810");
		lstArtefatosNexus.add(artefatosNexus);
		artefatosNexus.setGroupId("com.att.inno");
		artefatosNexus.setArtefato("log4j");
		artefatosNexus.setVersion("1.2.11");
		lstArtefatosNexus.add(artefatosNexus);
		return lstArtefatosNexus;
	}
	
}
