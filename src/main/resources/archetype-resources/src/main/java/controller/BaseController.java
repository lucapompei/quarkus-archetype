#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ${package}.constants.EndpointConstants;
import ${package}.service.InfoService;

/**
 * This rest controller exposes endpoints to handle the base requests
 * 
 * @author lucapompei
 *
 */
@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class BaseController {

	/**
	 * The logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	/**
	 * The info service
	 */
	@Inject
	InfoService infoService;

	/**
	 * Root Endpoint
	 *
	 * @return the root
	 */
	@GET
	@Path(value = EndpointConstants.ROOT)
	public Response getRoot() {
		return Response.ok("Ok").build();
	}

	/**
	 * This method exposes API to show the main application info
	 * 
	 * @return the main application info
	 */
	@GET
	@Path(value = EndpointConstants.ABOUT)
	public Response getAbout() {
		String response = infoService.getAppInfo();
		return Response.ok(response).build();
	}

	/**
	 * This method exposes API to show the application logs
	 * 
	 * @return the application logs
	 */
	@GET
	@Path(value = EndpointConstants.LOGS)
	public Response getLogs() {
		try {
			String response = infoService.getAppLogs();
			return Response.ok(response).build();
		} catch (Exception e) {
			String error = "Unable to get application logs: " + e.getMessage();
			LOGGER.error(error);
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(), error).build();
		}
	}

}
