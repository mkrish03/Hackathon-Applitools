package applitools.stepdefinitions;

import applitools.pageobjects.HomePage;
import applitools.pageobjects.LoginPage;
import applitools.utils.AssertUtils;
import applitools.utils.BaseUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * The Class TraditionalTestStepDefinitions.
 */
public class TraditionalTestStepDefinitions extends BaseUtils {

	/** The homepage. */
	public static HomePage homepage;

	/** The loginpage. */
	public static LoginPage loginpage;

	/**
	 * Launch the demo app.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@Given("^Launch the Demo APP$")
	public void launch_the_demo_app() throws Throwable {
		launchUrl(getAppProperties("url"));
	}

	/**
	 * Click on login.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@When("^Click on Login$")
	public void click_on_login() throws Throwable {
		loginpage = new LoginPage();
		loginpage.clickOnLogin();
	}

	/**
	 * Verify no credentials warning message.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@Then("^Verify No Credentials Warning message$")
	public void verify_no_credentials_warning_message() throws Throwable {
		if (loginpage.isNoCrednWarningMsgExist()) {
			AssertUtils.assertTrue(true, "Warning message successfully displayed");
		} else {
			AssertUtils.assertTrue(false, "Warning message displayed");
		}
	}

	/**
	 * Verify password warning message.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@Then("^Verify Password Warning message$")
	public void verify_password_warning_message() throws Throwable {
		if (loginpage.isPasswordWarningMsgExist()) {
			AssertUtils.assertTrue(true, "Password Warning message successfully displayed");
		} else {
			AssertUtils.assertTrue(false, "Password Warning message displayed");
		}
	}

	/**
	 * Verify username warning message.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@Then("^Verify Username Warning message$")
	public void verify_username_warning_message() throws Throwable {
		if (loginpage.isUserNameWarningMsgExist()) {
			AssertUtils.assertTrue(true, "Username Warning message successfully displayed");
		} else {
			AssertUtils.assertTrue(false, "Username Warning message displayed");
		}
	}

	/**
	 * Enter username.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@And("^Enter Username$")
	public void enter_username() throws Throwable {
		loginpage = new LoginPage();
		loginpage.enterUsername();
	}

	/**
	 * Enter password.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@And("^Enter Password$")
	public void enter_password() throws Throwable {
		loginpage = new LoginPage();
		loginpage.enterPassword();
	}

	/**
	 * Verify homepage is displayed.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@Then("^Verify homepage is displayed$")
	public void verify_homepage_is_displayed() throws Throwable {
		homepage = new HomePage();
		AssertUtils.assertTrue(homepage.isAmountExist(), "Username Warning message successfully displayed");
	}

	/**
	 * Verify the sorting order of amount.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@Then("^Verify the Sorting order of amount$")
	public void verify_the_sorting_order_of_amount() throws Throwable {
		AssertUtils.assertTrue(homepage.isAmountSortedCorrectly(), "Amount sorted correctly");
	}

	/**
	 * Verify the canvas chart.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@Then("^Verify the Canvas chart$")
	public void verify_the_canvas_chart() throws Throwable {
		// The chart can be automated using Sikuli libraries.
	}

	/**
	 * Click on amount.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@And("^Click on Amount$")
	public void click_on_amount() throws Throwable {
		homepage = new HomePage();
		homepage.clickOnAmount();
	}

	/**
	 * Click on compare expenses.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@And("^Click on Compare Expenses$")
	public void click_on_compare_expenses() throws Throwable {
		homepage = new HomePage();
		homepage.clickOnCompareExpense();
	}

	/**
	 * Launch the demo git app.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@Given("^Launch the demo git app$")
	public void launch_the_demo_git_app() throws Throwable {
		launchUrl("https://demo.applitools.com/hackathonV2.html?showAd=true");
	}

	/**
	 * Verify the git image in homepage.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	@Then("^Verify the git image in homepage$")
	public void verify_the_git_image_in_homepage() throws Throwable {
		homepage = new HomePage();
		AssertUtils.assertTrue(homepage.isGifImageDisplayed(), "Gif Images are displayed");
	}
}
