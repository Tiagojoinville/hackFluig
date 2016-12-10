package br.com.totvs.fluig.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import br.com.totvs.fluig.Model.ArtefatosNexus;
import br.com.totvs.fluig.service.FileGenerator;
import br.com.totvs.fluig.service.FolderGenerator;
import br.com.totvs.fluig.service.WidgetGenerator;

public class WidgetGeneratorImpl implements WidgetGenerator {
		
	public String generate(String nameApp, String packageName,String versionId, String dependencies){

		String zipFile = "";
		
		String dirHome = "/tmp/fluig/";

		// Deletando um diretório vazio
		boolean success = (new File("/tmp/fluig/")).delete();
		if(success){
			System.out.println("Deletei");
		}

		System.out.println("Inicio");

		/*
		 * FOLDERS
		 */
		FolderGenerator folderGenerator = new FolderGeneratorImpl();
		
		String tempFolder = folderGenerator.generateFolder(dirHome + "/temp/");
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
		fileGenerator.createRest(packages, nameApp);

		fileGenerator.createBootstrapJS(jsFolder);
		fileGenerator.createBootstrapTokenMiniJS(jsFolder);
		
		
	 	/*
		 * POM
		 */
		List<ArtefatosNexus> lstArtefatos =  getArtefatos();
		fileGenerator.createPom(tempFolder, nameApp,packageName,versionId, lstArtefatos);

		
		System.out.println("Fim");
		
		
		
		/*
		 * ZIP
		 */
		File directoryToZip = new File(dirHome + "/temp/");

		List<File> fileList = new ArrayList<File>();
		try {
			System.out.println("---Getting references to all files in: " + directoryToZip.getCanonicalPath());
			getAllFiles(directoryToZip, fileList);
			System.out.println("---Creating zip file");
			writeZipFile(directoryToZip, fileList, dirHome);
			System.out.println("---Done");
			zipFile = dirHome + "/temp.zip";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
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
	
	public static void getAllFiles(File dir, List<File> fileList) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				fileList.add(file);
				if (file.isDirectory()) {
					System.out.println("directory:" + file.getCanonicalPath());
					getAllFiles(file, fileList);
				} else {
					System.out.println("     file:" + file.getCanonicalPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeZipFile(File directoryToZip, List<File> fileList, String dirHome) {

		try {
			FileOutputStream fos = new FileOutputStream(dirHome + "/" + directoryToZip.getName() + ".zip");
			ZipOutputStream zos = new ZipOutputStream(fos);

			for (File file : fileList) {
				if (!file.isDirectory()) { // we only zip files, not directories
					addToZip(directoryToZip, file, zos);
				}
			}

			zos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addToZip(File directoryToZip, File file, ZipOutputStream zos) throws FileNotFoundException,
			IOException {

		FileInputStream fis = new FileInputStream(file);

		String zipFilePath = file.getCanonicalPath().substring(directoryToZip.getCanonicalPath().length() + 1,
				file.getCanonicalPath().length());
		System.out.println("Writing '" + zipFilePath + "' to zip file");
		ZipEntry zipEntry = new ZipEntry(zipFilePath);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}

		zos.closeEntry();
		fis.close();
	}

	// Deleta todos os arquivos e subdiretorios
	// Retorna verdadeiro se todas as remoções aconteceram com sucesso.
	// Se houve falha, o método será interrompido, e retornará falso.
	public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i=0; i<children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}

		// Agora o diretório está vazio, restando apenas deletá-lo.
		return dir.delete();
	}

}
