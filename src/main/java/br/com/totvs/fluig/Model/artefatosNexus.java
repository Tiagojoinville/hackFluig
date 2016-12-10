package br.com.totvs.fluig.Model;

/**
 * Created by Tiago J on 09/12/2016.
 */
public class ArtefatosNexus {
    private String groupId;
    private String artefato;
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getArtefato() {
        return artefato;
    }

    public void setArtefato(String artefato) {
        this.artefato = artefato;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
