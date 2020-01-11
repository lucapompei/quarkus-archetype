#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This service handles info requests
 * 
 * @author lucapompei
 *
 */
@ApplicationScoped
public class InfoService {

	/**
	 * The logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(InfoService.class);

	/**
	 * The application name
	 */
	@ConfigProperty(name = "application.app_name")
	String appName;

	/**
	 * The application version
	 */
	@ConfigProperty(name = "application.app_version")
	String appVersion;

	/**
	 * The application logs path
	 */
	@ConfigProperty(name = "quarkus.log.file.path")
	String logsPath;

	/**
	 * Retrieve the main application info
	 * 
	 * @return the main application info
	 */
	public String getAppInfo() {
		return this.appName + " - v." + this.appVersion;
	}

	/**
	 * Retrieve the application logs
	 * 
	 * @return the application logs
	 * @throws IOException
	 */
	public String getAppLogs() throws IOException {
		// Read logs
		LOGGER.debug("Getting logs from {}", logsPath);
		return Files.readString(Path.of(logsPath), StandardCharsets.US_ASCII);
	}

}
