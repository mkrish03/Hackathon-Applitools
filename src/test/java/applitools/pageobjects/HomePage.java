package applitools.pageobjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applitools.utils.BaseUtils;

/**
 * The Class HomePage.
 */
public class HomePage extends BaseUtils {

	/**
	 * Instantiates a new home page.
	 */
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	/** The amount. */
	@FindBy(id = "amount")
	public static WebElement amount;

	/** The compare expense chart. */
	@FindBy(id = "showExpensesChart")
	public static WebElement compareExpenseChart;

	/** The amount value. */
	@FindBy(xpath = "//table//td[@class='text-right bolder nowrap']//span")
	public static List<WebElement> amountValue;

	/** The gif element. */
	@FindBy(xpath = "//div[contains(@id,'flashSale')]//img")
	public static List<WebElement> gifElement;

	/**
	 * Click on amount.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public void clickOnAmount() throws Exception {
		click(amount, "Amount");
	}

	/**
	 * Click on compare expense.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public void clickOnCompareExpense() throws Exception {
		click(compareExpenseChart, "Compare Expenses");
	}

	/**
	 * Checks if is amount exist.
	 *
	 * @return true, if is amount exist
	 * @throws Exception
	 *             the exception
	 */
	public boolean isAmountExist() throws Exception {
		if (elementIsDisplayed(amount, "Amount")) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if gif images are displayed.
	 *
	 * @return true, if gif images are displayed
	 * @throws Exception
	 *             the exception
	 */
	public boolean isGifImageDisplayed() throws Exception {
		int count = 0;
		System.out.println(gifElement.size());
		if (gifElement.size() == 2) {
			for (WebElement e : gifElement) {
				if (e.isDisplayed()) {
					count++;
				}
			}
			System.out.println(count);
			if (count == 2) {
				return true;
			}
		} else {
			return false;
		}
		return false;
	}

	/**
	 * Checks if is amount sorted correctly.
	 *
	 * @return true, if is amount sorted correctly
	 * @throws Exception
	 *             the exception
	 */
	@SuppressWarnings("unused")
	public boolean isAmountSortedCorrectly() throws Exception {
		ArrayList<Integer> value = new ArrayList<Integer>();
		for (WebElement e : amountValue) {
			value.add(Double.valueOf(getText(e, "Amount Value").replace("USD", "").replace("+", "").replace(",", "")
					.replaceAll("\\s", "").trim()).intValue());
		}
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List tmp = new ArrayList(value);
		Collections.sort(value);
		int count = 0;
		for (int j = 0; j < value.size(); j++) {
			if (value.get(j).equals(tmp.get(j))) {
				count++;
			}
			if (count == value.size()) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}
