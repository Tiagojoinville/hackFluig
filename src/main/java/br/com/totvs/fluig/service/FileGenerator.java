package br.com.totvs.fluig.service;

import java.util.List;

import br.com.totvs.fluig.Model.ArtefatosNexus;

public interface FileGenerator {

	public void createFile(String path, String nameFile, String content);
	
	public void createApplication(String path, String nameApp);
	
	public void createProperties(String path, String nameApp);
	
	public void createEdit(String path, String nameApp);
	
	public void createView(String path, String nameApp);

	public void createWebXml(String path);

    public void createRest(String path, String nameApp);

	public void createPom(String path, String nameApp, String packageName,String versionId, List<ArtefatosNexus> lstArtefanatos);

    public void createJbossWeb(String path, String nameApp);

    public void createCssFile(String path, String nameApp);
}
