package br.com.totvs.tdi.fluig.credentials.rest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.totvs.technology.wcm.common.WCMRestResult;
import com.totvs.technology.wcm.sdk.rest.WCMRest;

@Path("/generate")
public class SecurityRest extends WCMRest {

    @PersistenceContext(name="FluigPU")
    private EntityManager em;
    
    private static Logger LOGGER = LoggerFactory.getLogger(SecurityRest.class);
    
    
    
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/widget/{code}")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Response getSecureCredentials(@javax.ws.rs.core.Context HttpServletRequest req, @PathParam("code") String code) {
    	
    	LOGGER.info("getSecureCredentials code:" + code);
    	
    	String versionFluig;
    	String packageName;
    	String name;
    	String listDependencies;

		
    	
    	
    	String user;
		String pass;

    	switch (code) {
    		case "fluig":
    			user = "JV.TDI.PORTAIS@totvs.com.br";
    			pass = "teste@123";
    			break;
    		case "portal":
    			user = "JV.TDI.PORTAIS@totvs.com.br";
    			pass = "totvs@123";
    			break;
    		default:
    			user = "";
    			pass = "";
    	}		

		try {

			String result = user + pass;

    		return this.buildJSONResponse(new WCMRestResult(result));

    	} catch (Exception e){

    		LOGGER.error("Erro");			
			return this.buildJSONResponse(e, super.getWCMSDK().getLocale());

    	}
    }

   
    
}

