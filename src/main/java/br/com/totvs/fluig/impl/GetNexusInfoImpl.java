package br.com.totvs.fluig.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.totvs.fluig.service.GetNexusInfo;

public class GetNexusInfoImpl implements GetNexusInfo {
	
	public static void main(String args[]){
		getNexus();
	}
	
	public static List<String> getNexus(){

		List<String> retorno = new ArrayList<String>();
		
		JSONObject json;
		try {
			json = readJsonFromUrl("http://nexus.fluig.com/content/groups/public");
			System.out.println(json.toString());
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return retorno;
	}
	
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }
	
	private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream(); 
        try {
			System.out.println("DEBUG");
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
        	is.close(); 
        }
    }
}
