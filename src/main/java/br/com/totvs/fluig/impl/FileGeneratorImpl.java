package br.com.totvs.fluig.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import br.com.totvs.fluig.Model.ArtefatosNexus;
import br.com.totvs.fluig.service.FileGenerator;

public class FileGeneratorImpl implements FileGenerator {

	public void createFile(String path, String nameFile, String content){
		
		Writer writer = null;
		
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(path + nameFile), "utf-8"));
		    
		    writer.write(content);
		    
		} catch (IOException ex) {
		  // report
		} finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
				
	}
	
	public void createApplication(String path, String nameApp){
						
		StringBuilder content = new StringBuilder();
		
		content.append("application.type=widget \n");
		content.append("application.code=" + nameApp + "\n");
	    content.append("application.title=" + nameApp + "\n");
	    content.append("application.description=" + nameApp + "\n");
	    content.append("application.category=SYSTEM \n");
	    content.append("application.renderer=freemarker \n");
	    content.append("developer.code=TOTVS \n");
	    content.append("developer.name=TOTVS \n");
	    content.append("developer.url=http://www.fluig.com \n");
	    content.append("application.uiwidget=true \n");
	    content.append("view.file=view.ftl \n");
	    content.append("edit.file=edit.ftl \n");
	    content.append("application.resource.css.1=/resources/css/" + nameApp + ".css \n");
	    content.append("application.resource.js.1=/resources/js/" + nameApp + ".js");
	    
	    createFile(path, "application.info", content.toString());
	    
	}
	
	public void createProperties(String path, String nameApp){
			
			StringBuilder content = new StringBuilder();
			content.append(nameApp + ".labeltitulo=" + nameApp);
		    
			createFile(path, nameApp + ".properties", content.toString());
			createFile(path, nameApp + "_en_US.properties", content.toString());
			createFile(path, nameApp + "_es.properties", content.toString());
			createFile(path, nameApp + "_pt_BR.properties", content.toString());		    
	}
	
	public void createEdit(String path, String nameApp){
		
		StringBuilder content = new StringBuilder();
		content.append("");
	    
		createFile(path, "edit.ftl", content.toString());
	}
	
	public void createView(String path, String nameApp){
		
		StringBuilder content = new StringBuilder();
		content.append("<div id=' " + nameApp + "_${instanceId}' class='super-widget wcm-widget-class fluig-style-guide'\n");
		content.append("data-params='" + nameApp + ".instance({message: \"Hello world\"})'>\n");
		content.append("<h1>Hello world</h1>\n");
		content.append("<div>\n");
		content.append("<button type='button' class='btn btn-default' data-show-message>Show</button>\n");
		content.append("</div>\n");
		content.append("<div id='" + nameApp + "_${instanceId}'>\n");
		content.append("</div>\n");
		content.append("</div>");

		createFile(path, "view.ftl", content.toString());
	}
	
	public void createPom(String path, String nameApp, String packageName,String versionId, List<ArtefatosNexus> lstArtefanatos){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		stringBuilder.append("<project xmlns=\"http://maven.apache.org/POM4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\n");
		stringBuilder.append("	xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd>\n");
		stringBuilder.append("	<modelVersion>4.0.0</modelVersion>\n");
		stringBuilder.append("        <groupId> " + packageName +"</groupId>\n");
		stringBuilder.append("	<artifactId>" + nameApp + "</artifactId>\n");
		stringBuilder.append("	<version>" + versionId + "</version>\n");
		stringBuilder.append("	<packaging>war</packaging>\n");
		stringBuilder.append("	<name>" + nameApp + "</name>\n");
		stringBuilder.append("	<description>" + nameApp + "</description>\n");
		stringBuilder.append("	<properties>\n");
		stringBuilder.append("		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>\n");
		stringBuilder.append("	</properties>\n");
		stringBuilder.append("	<dependencies>\n");
		stringBuilder.append("        <dependency>\n");
		stringBuilder.append("			<groupId>com.fluig</groupId>\n");
		stringBuilder.append("			<artifactId>foundation-oauth-api</artifactId>\n");
		stringBuilder.append("			<version>1.5.0</version>\n");
		stringBuilder.append("			<scope>compile</scope>\n");
		stringBuilder.append("		</dependency>\n");
		stringBuilder.append("		<dependency>\n");
		stringBuilder.append("		    <groupId>org.json</groupId>\n");
		stringBuilder.append("		    <artifactId>json</artifactId>\n");
		stringBuilder.append("		    <version>20160810</version>\n");
		stringBuilder.append("		</dependency>\n");

		for(ArtefatosNexus artefatos : lstArtefanatos){
			stringBuilder.append("		    <groupId> " + artefatos.getGroupId() +"</groupId>\n");
			stringBuilder.append("		    <artifactId>" + artefatos.getArtefato() + "</artifactId>\n");
			stringBuilder.append("		    <version>" + artefatos.getVersion() + "</version>\n");
			stringBuilder.append("		</dependency>\n");
		}

		stringBuilder.append("		<dependency>\n");
		stringBuilder.append("			<groupId>com.fluig</groupId>\n");
		stringBuilder.append("			<artifactId>wcm-sdk-service</artifactId>\n");
		stringBuilder.append("			<version>1.5.0</version>\n");
		stringBuilder.append("			<scope>provided</scope>\n");
		stringBuilder.append("		</dependency>\n");
		stringBuilder.append("        <dependency>\n");
		stringBuilder.append("            <groupId>com.fluig</groupId>\n");
		stringBuilder.append("            <artifactId>foundation-sdk-service</artifactId>\n");
		stringBuilder.append("            <version>1.5.0</version>\n");
		stringBuilder.append("			<scope>provided</scope>\n");
		stringBuilder.append("        </dependency>\n");
		stringBuilder.append("        <dependency>\n");
		stringBuilder.append("            <groupId>com.fluig</groupId>\n");
		stringBuilder.append("            <artifactId>wcm-common</artifactId>\n");
		stringBuilder.append("            <version>1.5.0</version>\n");
		stringBuilder.append("            <scope>provided</scope>\n");
		stringBuilder.append("        </dependency>\n");
		stringBuilder.append("		<dependency>\n");
		stringBuilder.append("			<groupId>com.fluig</groupId>\n");
		stringBuilder.append("			<artifactId>foundation-common</artifactId>\n");
		stringBuilder.append("			<version>1.5.0</version>\n");
		stringBuilder.append("			<scope>provided</scope>\n");
		stringBuilder.append("		</dependency>\n");
		stringBuilder.append("		<!-- Foundation Dependencies -->\n");
		stringBuilder.append("		<dependency>\n");
		stringBuilder.append("			<groupId>com.fluig</groupId>\n");
		stringBuilder.append("			<artifactId>foundation-security-base-api</artifactId>\n");
		stringBuilder.append("			<version>1.5.0</version>\n");
		stringBuilder.append("			<scope>provided</scope>\n");
		stringBuilder.append("		</dependency>\n");
		stringBuilder.append("		<!-- JEE Dependencies -->\n");
		stringBuilder.append("		<dependency>\n");
		stringBuilder.append("			<groupId>javax</groupId>\n");
		stringBuilder.append("			<artifactId>javaee-api</artifactId>\n");
		stringBuilder.append("			<scope>provided</scope>)\n");
		stringBuilder.append("			<version>LATEST</version>\n");
		stringBuilder.append("		</dependency>\n");
		stringBuilder.append("        <dependency>\n");
		stringBuilder.append("              <groupId>com.fluig</groupId>\n");
		stringBuilder.append("              <artifactId>foundation-integration-idp-api</artifactId>\n");
		stringBuilder.append("              <version>1.5.0</version>\n");
		stringBuilder.append("              <scope>provided</scope>\n");
		stringBuilder.append("        </dependency>\n");
		stringBuilder.append("	</dependencies>\n");
		stringBuilder.append("	<build>\n");
		stringBuilder.append("		<plugins>\n");
		stringBuilder.append("			<plugin>\n");
		stringBuilder.append("				<groupId>org.apache.maven.plugins</groupId>\n");
		stringBuilder.append("				<artifactId>maven-compiler-plugin</artifactId>\n");
		stringBuilder.append("				<configuration>\n");
		stringBuilder.append("					<source>1.7</source>\n");
		stringBuilder.append("					<target>1.7</target>\n");
		stringBuilder.append("				</configuration>\n");
		stringBuilder.append("			</plugin>\n");
		stringBuilder.append("		</plugins>\n");
		stringBuilder.append("		<finalName>appName</finalName>\n");
		stringBuilder.append("	</build>\n");
		stringBuilder.append("</project>\n");

		createFile(path, "pom.xml", stringBuilder.toString());
	}
	
}
