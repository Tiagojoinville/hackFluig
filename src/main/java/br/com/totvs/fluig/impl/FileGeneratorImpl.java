package br.com.totvs.fluig.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

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
	
	public void createApplication(String path){
		
		String nameApp = "totvs_something";
		
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
	    
	    createFile(path, "properties", content.toString());
	    
	}
	
	public void createProperties(String path){
			
			String nameApp = "totvs_something";
			
			StringBuilder content = new StringBuilder();
			content.append("application.type=widget \n");
			content.append("application.code=" + nameApp + "\n");
		   		    
		    createFile(path, "properties", content.toString());
		    
	}
	
}
