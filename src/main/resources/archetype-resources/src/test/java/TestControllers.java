#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import ${package}.controller.BaseController;

/**
 * This class is used to test the application controllers
 * 
 * @author lucapompei
 *
 */
@QuarkusTest
public class TestControllers {

	/**
	 * The base controller
	 */
	@Inject
	private BaseController baseController;

	/**
	 * Test the root endpoint
	 */
	@DisplayName("Testing root API")
	@Test
	public void testRoot() {
		Assertions.assertNotNull(baseController.getRoot(), "Unable to get root");
	}

	/**
	 * Test the about endpoint
	 */
	@DisplayName("Testing about API")
	@Test
	public void testAbout() {
		Assertions.assertNotNull(baseController.getAbout(), "Unable to get about");
	}

	/**
	 * Test the logs endpoint
	 */
	@DisplayName("Testing logs API")
	@Test
	public void testLogs() {
		Assertions.assertNotNull(baseController.getLogs(), "Unable to get logs");
	}

}
