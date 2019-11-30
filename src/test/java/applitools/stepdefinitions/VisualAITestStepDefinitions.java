package applitools.stepdefinitions;

import applitools.pageobjects.HomePage;
import applitools.pageobjects.LoginPage;
import applitools.utils.BaseUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * The Class VisualAITestStepDefinitions.
 */
public class VisualAITestStepDefinitions extends BaseUtils {

	/** The homepage. */
	public static HomePage homepage;

	/** The loginpage. */
	public static LoginPage loginpage;

	/**
	 * Launch the demo app version 2.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@Given("^Launch the Demo APP version2$")
	public void launch_the_demo_app_version2() throws Throwable {
		Hooks.eyes.open(driver, "Demo App", "Smoke Test");
		launchUrl(getAppProperties("url"));
	}

	/**
	 * Verify login page.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@Then("^Verify login page$")
	public void verify_login_page() throws Throwable {
		Hooks.eyes.checkWindow("Login Window");
	}

	/**
	 * Verify the no credentials warning message.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@Then("^Verify the no credentials warning message$")
	public void verify_the_no_credentials_warning_message() throws Throwable {
		Hooks.eyes.checkWindow("No Credentials Warning Message");
	}

	/**
	 * Verify the password warning message.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@Then("^Verify the Password warning message$")
	public void verify_the_password_warning_message() throws Throwable {
		Hooks.eyes.checkWindow("No Password Warning Message");
	}

	/**
	 * Verify the username warning message.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@Then("^Verify the Username warning message$")
	public void verify_the_username_warning_message() throws Throwable {
		Hooks.eyes.checkWindow("No Username Warning Message");
	}

	/**
	 * Verify the home page.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@Then("^Verify the Home page$")
	public void verify_the_home_page() throws Throwable {
		Hooks.eyes.checkWindow("Home Page");
	}

	/**
	 * Verify the amount sorting.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@Then("^Verify the Amount sorting$")
	public void verify_the_amount_sorting() throws Throwable {
		Hooks.eyes.checkWindow("Amount Ascending");
	}

	/**
	 * Verify the canvas chart page.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@Then("^Verify the Canvas chart page$")
	public void verify_the_canvas_chart_page() throws Throwable {
		Hooks.eyes.checkWindow("Canvas chart");
	}

	/**
	 * Click on the login button.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@And("^Click on the  login button$")
	public void click_on_the_login_button() throws Throwable {
		loginpage = new LoginPage();
		loginpage.clickOnLogin();
	}

	/**
	 * Clear username field.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@And("^Clear Username field$")
	public void clear_username_field() throws Throwable {
		loginpage.clearUsername();
	}

	/**
	 * Launch the demo GIF APP version.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@Given("^Launch the Demo GIF APP version$")
	public void launch_the_Demo_GIF_APP_version() throws Throwable {

		launchUrl("https://demo.applitools.com/hackathonV2.html?showAd=true");
	}

	/**
	 * Verify the GIF image.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@Then("^Verify the GIF Image$")
	public void verify_the_GIF_Image() throws Throwable {
		Hooks.eyes.checkWindow("Gif Image in Home Page");
		Hooks.eyes.closeAsync();
	}

}
