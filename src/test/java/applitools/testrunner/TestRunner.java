package applitools.testrunner;

import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.TestNG;
import org.testng.annotations.Test;

/**
 * The Class TestRunner is used to maintain the execution of scenario using
 * TestNG and log4j configuration
 */
public class TestRunner {

	/** The Constant LOGGER. */
	final public static Logger LOGGER = Logger.getLogger(TestRunner.class);

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws Exception
	 *             the exception
	 */
	// public static void main(String[] args) throws Exception {
	@Test
	public void executeTest() {
		testRunner();
	}

	/**
	 * Test runner.
	 */
	public static void testRunner() {
		try {
			deleteOldLog();
			String log4jConfPath = "log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);
			TestNG testNG = new TestNG();
			testNG.setTestClasses(new Class[] { RunCukesTest.class });
			testNG.run();
		} catch (Exception e) {
			LOGGER.info(e);
		}

	}

	/**
	 * Delete old log is used to delete the old execution log file.
	 *
	 * @return nothing
	 * @exception Exception
	 *                the exception
	 */
	public static void deleteOldLog() throws Exception {
		File file = new File("executionlog.log");
		if (file.exists()) {
			file.delete();
		}
	}

}
