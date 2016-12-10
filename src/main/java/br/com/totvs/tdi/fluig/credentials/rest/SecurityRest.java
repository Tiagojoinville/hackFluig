package br.com.totvs.tdi.fluig.credentials.rest;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.totvs.fluig.impl.FileGeneratorImpl;
import br.com.totvs.fluig.impl.WidgetGeneratorImpl;
import br.com.totvs.fluig.service.FileGenerator;
import br.com.totvs.fluig.service.WidgetGenerator;

import com.totvs.technology.wcm.common.WCMRestResult;
import com.totvs.technology.wcm.sdk.rest.WCMRest;

@Path("/generate")
public class SecurityRest extends WCMRest {
    
    private static Logger LOGGER = LoggerFactory.getLogger(SecurityRest.class);

    @GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/widget")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Response getWidget(@javax.ws.rs.core.Context HttpServletRequest req, @PathParam("dependecies") String dependecies) {
    	
    	LOGGER.info("getWidget");
    	    	
    	String versionFluig;
    	String nameApp = "totvs_something";
		String packageName = "com.totvs.fluig";
		String dependencies = "org,abc";

    	WidgetGenerator wdgt = new WidgetGeneratorImpl();

		try {
	    	String finalPath = wdgt.generate(nameApp, packageName, dependencies);
	    	return this.buildJSONResponse(new WCMRestResult(finalPath));

    	} catch (Exception e){

    		LOGGER.error("Erro");			
			return this.buildJSONResponse(e, super.getWCMSDK().getLocale());

    	}
    }
}