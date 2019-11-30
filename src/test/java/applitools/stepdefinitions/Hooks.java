package applitools.stepdefinitions;

import org.apache.log4j.Logger;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;

import applitools.utils.BaseUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseUtils {

	/** The runner. */
	private static EyesRunner runner;

	/** The eyes. */
	public static Eyes eyes;

	/** The batch. */
	private static BatchInfo batch;

	private static int ScenarioID = 1;

	/** The Constant LOGGER. */
	final public static Logger LOGGER = Logger.getLogger(BaseUtils.class);

	@Before
	public void beforeEach() throws Exception {
		// Must be before ALL tests (at Class-level)
		batch = new BatchInfo("Demo batch");

		// Initialize the Runner for your test.
		runner = new ClassicRunner();

		// Initialize the eyes SDK
		eyes = new Eyes(runner);

		// Set your personal Applitols API Key from your environment variables.
//		eyes.setApiKey(System.getenv("API_KEY"));
		eyes.setApiKey("BXpZCmY104QoX1084Ua97ld1ctUXKFQxkB2y98oHH102QW0a0Is110");

		// set batch name
		eyes.setBatch(batch);

		eyes.setForceFullPageScreenshot(true);

		eyes.getHideScrollbars();
		LOGGER.info("============================ Scenario " + ScenarioID + "==================================");
		launchBrowser();
	}

	@After
	public void afterEach() throws Exception {

		// End the test.
//		eyes.closeAsync();

		// Close the browser.
		quitBrowser();
		LOGGER.info("============================ End of Scenario " + ScenarioID + "===========================");
		ScenarioID++;

		// If the test was aborted before eyes.close was called, ends the test as
		// aborted.
		eyes.abortIfNotClosed();

	}

}
