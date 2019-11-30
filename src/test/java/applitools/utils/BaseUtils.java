package applitools.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.cucumber.listener.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * The Class BaseUtils is used to maintain all base functions used for element
 * actions.
 */
public class BaseUtils {

	/** The driver. */
	public static WebDriver driver = null;

	/** The n. */
	private static int n = 0;

	/** The Constant LOGGER. */
	final public static Logger LOGGER = Logger.getLogger(BaseUtils.class);

	/**
	 * Launch browser.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void launchBrowser() throws Exception {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} catch (Exception e) {
			LOGGER.error("Browser not launched");
			LOGGER.error(e);
		}
	}

	/**
	 * Launch url.
	 *
	 * @param url
	 *            the url
	 * @throws Exception
	 *             the exception
	 */
	public static void launchUrl(String url) throws Exception {
		try {
		driver.get(url);
		LOGGER.info("URL Launched");
		}
		catch(Exception e) {
			LOGGER.error("URL not launched");
			LOGGER.error(e);
		}
	}

	/**
	 * This method is used to get the value from data.properties file.
	 *
	 * @param key
	 *            This is the first parameter to getAppProperties method
	 * @return String This returns the corresponding value for the key.
	 * @exception IOException
	 *                Signals that an I/O exception has occurred.
	 */
	public static String getAppProperties(String key) throws IOException {
		String value = "";
		try {

			FileInputStream fileInputStream = new FileInputStream("data.properties");
			Properties property = new Properties();
			property.load(fileInputStream);
			value = property.getProperty(key);
			fileInputStream.close();
		} catch (Exception e) {
			LOGGER.error("Exception Thrown");
			LOGGER.error(e);
		}
		return value;

	}

	/**
	 * This method is used to get text for an element in the application.
	 *
	 * @param element
	 *            This is the first parameter to getText method
	 * @param elementName
	 *            This is the second parameter to getText method
	 * @return String This returns the element's text value.
	 * @exception Exception
	 *                the exception
	 */
	public String getText(WebElement element, String elementName) throws Exception {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60, 500);
			wait.until(ExpectedConditions.visibilityOf(element));
			text = element.getText();
			Reporter.addStepLog("Get text from " + elementName + " successful");
			Reporter.addScreenCaptureFromPath(screenshot());
			 LOGGER.info("Get text from " + elementName + " successful");
			return text;
		} catch (Exception exc) {
			exc.printStackTrace();
			Reporter.addScreenCaptureFromPath(screenshot());
			Assert.assertTrue(false, "Exception on Get Text from webelement " + elementName);
			 LOGGER.error("Exception on Get Text from webelement" + elementName);
			 LOGGER.error(exc);
			throw new Exception();
		}
	}

	/**
	 * This method is used to enter text for an element in the application.
	 *
	 * @param element
	 *            This is the first parameter to enterText method
	 * @param value
	 *            This is the second parameter to enterText method
	 * @param elementName
	 *            This is the third parameter to enterText method
	 * @return Nothing.
	 * @exception Exception
	 *                the exception
	 */
	public void enterText(WebElement element, String value, String elementName) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60, 500);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(value);
			Reporter.addStepLog("Enter text in " + elementName + " successful");
			Reporter.addScreenCaptureFromPath(screenshot());
			 LOGGER.info("Enter text in " + elementName + " successful");
		} catch (Exception exc) {
			exc.printStackTrace();
			Reporter.addScreenCaptureFromPath(screenshot());
			Assert.assertTrue(false, "Exception on Get Text from webelement " + elementName);
			LOGGER.error("Exception on Get Text from webelement" + elementName);
			 LOGGER.error(exc);
			throw new Exception();
		}
	}

	/**
	 * Click.
	 *
	 * @param element
	 *            the element
	 * @param elementName
	 *            the element name
	 * @throws Exception
	 *             the exception
	 */
	public void click(WebElement element, String elementName) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60, 500);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			Reporter.addStepLog("Clicking webelement " + elementName + " successful");
			Reporter.addScreenCaptureFromPath(screenshot());
			LOGGER.info("Clicking webelement " + elementName + " successful");
		} catch (Exception exc) {
			exc.printStackTrace();
			Reporter.addScreenCaptureFromPath(screenshot());
			Assert.assertTrue(false, "Exception on clicking webelement " + elementName);
			LOGGER.error("Exception on clicking webelement " + elementName);
			LOGGER.error(exc);
			throw new Exception();
		}
	}

	/**
	 * This method is used to take a screenshot.
	 *
	 * @return String This returns image path of screenshot taken.
	 * @exception IOException
	 *                On input error.
	 * @exception InterruptedException
	 *                the interrupted exception
	 */
	public static String screenshot() throws IOException, InterruptedException {
		String imgPath = null;
		n = n + 1;
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_MM_SS");
		Date date = new Date();
		String timeStamp = dateFormat.format(date);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		imgPath = "target/cucumber-reports" + "/screenshots" + "/" + timeStamp + ".png";
		FileUtils.copyFile(scrFile, new File(imgPath));
		return new File(imgPath).getAbsolutePath();
	}

	/**
	 * This method is used to check if element is displayed in the application.
	 * 
	 * @param element
	 *            This is the first parameter to elementIsDisplayed method
	 * @param ElementName
	 *            This is the second parameter to elementIsDisplayed method
	 * @return boolean This returns if element is displayed or not.
	 * @exception Exception
	 *                On error.
	 */
	public boolean elementIsDisplayed(WebElement element, String ElementName) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30, 500);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception exc) {

		}
		try {
			if (element.isDisplayed()) {
				return true;
			} else
				return false;
		} catch (Exception exc) {
			return false;
		}
	}

	/**
	 * Quit browser.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public static void quitBrowser() throws Exception {
		driver.quit();
	}

}
