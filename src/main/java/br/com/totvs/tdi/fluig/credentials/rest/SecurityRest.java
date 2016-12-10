package br.com.totvs.tdi.fluig.credentials.rest;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.totvs.fluig.impl.WidgetGeneratorImpl;
import br.com.totvs.fluig.service.WidgetGenerator;

import com.totvs.technology.wcm.common.WCMRestResult;
import com.totvs.technology.wcm.sdk.rest.WCMRest;

import java.io.File;

@Path("/generate")
public class SecurityRest extends WCMRest {
    
    private static Logger LOGGER = LoggerFactory.getLogger(SecurityRest.class);
	private static final String FILE_PATH = "D:\\fluig\\jboss\\standalone\\tmp\\temp.zip";

    @POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/widget")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Response getWidget(@javax.ws.rs.core.Context HttpServletRequest req, @QueryParam("dependecies") String dependencies,
			@QueryParam("nameApp") String nameApp, @QueryParam("packageName") String packageName, @QueryParam("versionFluig") String versionFluig) {
    	
    	LOGGER.info("getWidget");
    	    	
    	//String versionFluig;
    	//String  = "totvs_something";
		//String  = "com.totvs.fluig";

    	WidgetGenerator wdgt = new WidgetGeneratorImpl();

		try {
	    	String finalPath = wdgt.generate(nameApp, packageName, versionFluig, dependencies);
	    	return this.buildJSONResponse(new WCMRestResult(finalPath));

    	} catch (Exception e){

    		LOGGER.error("Erro");			
			return this.buildJSONResponse(e, super.getWCMSDK().getLocale());

    	}
    }

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getFile(@javax.ws.rs.core.Context HttpServletRequest req) {
		File file = new File(FILE_PATH);
		Response.ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=" + FILE_PATH);
		return response.build();

	}
}