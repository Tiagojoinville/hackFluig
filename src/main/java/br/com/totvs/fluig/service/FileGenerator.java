package br.com.totvs.fluig.service;

import br.com.totvs.fluig.Model.ArtefatosNexus;

import java.util.List;

public interface FileGenerator {

	public void createFile(String path, String nameFile, String content);
	
	public void createApplication(String path, String nameApp);
	
	public void createProperties(String path, String nameApp);
	
	public void createEdit(String path, String nameApp);
	
	public void createView(String path, String nameApp);

	public void createWebXml(String path);

    public void createRest(String path, String nameApp, String dependencies);

	public void createPom(String path, String nameApp, String packageName,String versionId, List<ArtefatosNexus> lstArtefanatos);
}
