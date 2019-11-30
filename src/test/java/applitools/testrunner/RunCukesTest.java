package applitools.testrunner;

import java.io.File;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * The Class RunCukesTest is used to maintain the cucumber configuration.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = /* "json:cucumber.json" */ {
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, features = "src/test/java/applitools/features", glue = "applitools.stepdefinitions", monochrome = true)

public class RunCukesTest extends AbstractTestNGCucumberTests {

	/**
	 * Write extent report.
	 */
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("ExtentReport.xml"));
	}

}
