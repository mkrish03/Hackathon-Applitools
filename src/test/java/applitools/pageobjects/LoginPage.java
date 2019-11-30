package applitools.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applitools.utils.BaseUtils;

/**
 * The Class LoginPage.
 */
public class LoginPage extends BaseUtils {

	/**
	 * Instantiates a new login page.
	 */
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	/** The username. */
	@FindBy(id = "username")
	public static WebElement username;

	/** The password. */
	@FindBy(id = "password")
	public static WebElement password;

	/** The login. */
	@FindBy(id = "log-in")
	public static WebElement login;

	/** The error msg. */
	@FindBy(xpath= "//div[@class='alert alert-warning']")
	public static WebElement errorMsg;

	/**
	 * Enter username.
	 *
	 * @throws Exception the exception
	 */
	public void enterUsername() throws Exception {
		enterText(username, getAppProperties("username"), "Username");
	}

	/**
	 * Enter password.
	 *
	 * @throws Exception the exception
	 */
	public void enterPassword() throws Exception {
		enterText(password, getAppProperties("password"), "Password");
	}

	/**
	 * Click on login.
	 *
	 * @throws Exception the exception
	 */
	public void clickOnLogin() throws Exception {
		click(login, "Login");
	}
	
	/**
	 * Clear username.
	 *
	 * @throws Exception the exception
	 */
	public void clearUsername() throws Exception{
		username.clear();
	}
	
	/**
	 * Clear password.
	 *
	 * @throws Exception the exception
	 */
	public void clearPassword() throws Exception{
		password.clear();
	}

	/**
	 * Checks if is no credn warning msg exist.
	 *
	 * @return true, if is no credn warning msg exist
	 * @throws Exception the exception
	 */
	public boolean isNoCrednWarningMsgExist() throws Exception {
		if (getText(errorMsg, "Warning message").equals("Both Username and Password must be present")) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if is user name warning msg exist.
	 *
	 * @return true, if is user name warning msg exist
	 * @throws Exception the exception
	 */
	public boolean isUserNameWarningMsgExist() throws Exception {
		if (getText(errorMsg, "Warning message").equals("Username must be present")) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if is password warning msg exist.
	 *
	 * @return true, if is password warning msg exist
	 * @throws Exception the exception
	 */
	public boolean isPasswordWarningMsgExist() throws Exception {
		if (getText(errorMsg, "Warning message").equals("Password must be present")) {
			return true;
		}
		return false;
	}

}
