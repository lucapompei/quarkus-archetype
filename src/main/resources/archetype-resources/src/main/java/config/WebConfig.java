#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * This config class globally configure the web requests
 * 
 * @author lucapompei
 *
 */
@Provider
public class WebConfig implements ContainerRequestFilter, ContainerResponseFilter {

	/**
	 * The logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);

	/**
	 * The current url info
	 */
	@Context
	private UriInfo info;

	/**
	 * Filter the request before its execution
	 */
	@Override
	public void filter(ContainerRequestContext context) {
		// Configure the logger to uniquely record the request
		MDC.clear();
		MDC.put("uuid", UUID.randomUUID().toString() + new Date().getTime());
		// Find servlet name
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Requesting for {}", info.getPath());
		}
		// Register startTime
		context.setProperty("startTime", System.currentTimeMillis());
	}

	/**
	 * Filter the request after its execution
	 */
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		Object requestPropetry = requestContext.getProperty("startTime");
		if (requestPropetry != null) {
			long startTime = (long) requestPropetry;
			// Calculate elapsed time
			long elapsed = System.currentTimeMillis() - startTime;
			// Log result
			String name = info.getPath();
			LOGGER.info("Returned response for {} in {} ms", name, elapsed);
		}
	}
}
