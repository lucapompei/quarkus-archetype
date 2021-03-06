#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.constants;

/**
 * This utility class expose endpoint constants
 * 
 * @author lucapompei
 *
 */
public class EndpointConstants {

	/**
	 * The root endpoint
	 */
	public static final String ROOT = "/";

	/**
	 * The about endpoint
	 */
	public static final String ABOUT = "/about";

	/**
	 * The logs endpoint
	 */
	public static final String LOGS = "/logs";

	/**
	 * Private constructor for an utility class
	 */
	private EndpointConstants() {
		throw new IllegalAccessError(CommonConstants.STANDARD_MESSAGE_UTILITY_CLASS);
	}

}
