package applitools.utils;

import org.apache.log4j.Logger;
import org.testng.Assert;
import com.cucumber.listener.Reporter;

/**
 * The Class AssertUtils is used to verify assertions
 * 
 * @version 1.0
 */
public class AssertUtils {

	/** The Constant LOGGER. */
	final public static Logger LOGGER = Logger.getLogger(AssertUtils.class);

	/**
	 * Assert true.
	 *
	 * @param message
	 *            the message
	 * @throws Exception
	 *             the exception
	 */
	public static void assertTrue(boolean bool, String message) throws Exception {
		try {
			Assert.assertTrue(bool, message);
			LOGGER.info(message);
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			Reporter.addStepLog(message);
			Reporter.addScreenCaptureFromPath(BaseUtils.screenshot());
		}
	}

	/**
	 * Assert false.
	 *
	 * @param message
	 *            the message
	 * @throws Exception
	 *             the exception
	 */
	public static void assertFalse(boolean bool, String message) throws Exception {
		try {
			Assert.assertFalse(bool, message);
			LOGGER.info(message);
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			Reporter.addStepLog(message);
			Reporter.addScreenCaptureFromPath(BaseUtils.screenshot());
		}
	}
}