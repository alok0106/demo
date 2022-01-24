package com.adi;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import abc.ConfigProvider;
import abc.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class stepDefinition {

	WebDriver driver = null;
	DemoblazeElements demoBlazeElements = new DemoblazeElements();
	WebDriverWait driverWait;
	String expectedAmount;
	static Logger log = LogManager.getLogger(stepDefinition.class);

	ConfigProvider provider = new ConfigProvider();
	Map<String, String> mapConfig = provider.getPropValues();

	String chromeDriverPath = mapConfig.get("chromeDriver");
	String baseUrl = mapConfig.get("baseURL");

	@Before
	public void web_browser_is_open() throws Throwable {

		System.setProperty("webdriver.chrome.driver", chromeDriverPath);

		driver = new ChromeDriver();
		Thread.sleep(3000);
		driver.manage().window().maximize();

		Thread.sleep(5000);
		driverWait = new WebDriverWait(driver, 75);
	}

	@Given("^Customer is on demoblaze homepage$")
	public void Customer_is_on_demoblaze_homepage() throws Throwable {

		// String baseUrl = System.getProperty("baseURL");

		driver.navigate().to(baseUrl);
		Thread.sleep(10000);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^customer navigates to Phones category$")
	public void customer_navigates_to_Phones_category() throws Throwable {

		driverWait.until(ExpectedConditions.visibilityOfElementLocated(demoBlazeElements.phones));
		WebElement webElement = driver.findElement(demoBlazeElements.phones);
		Assert.assertEquals(Utility.isClicked(webElement, driver), true);

	}

	@Then("^customer navigates to Laptops category$")
	public void customer_navigates_to_Laptops_category() throws Throwable {

		driverWait.until(ExpectedConditions.visibilityOfElementLocated(demoBlazeElements.laptops));
		WebElement webElement = driver.findElement(demoBlazeElements.laptops);
		Assert.assertEquals(Utility.isClicked(webElement, driver), true);
		Thread.sleep(5000);
	}

	@Given("^customer navigates to Monitors category$")
	public void customer_navigates_to_Monitors_category() {

		driverWait.until(ExpectedConditions.visibilityOfElementLocated(demoBlazeElements.monitors));
		WebElement webElement = driver.findElement(demoBlazeElements.monitors);
		Assert.assertEquals(Utility.isClicked(webElement, driver), true);

	}

	@Then("^clicks on (.*) laptop$")
	public void clicks_on_laptop(String laptop) throws Throwable {

		if (laptop.equals("sony vaio i5")) {
			WebElement webElement = driver.findElement(demoBlazeElements.sonyVaioI5Laptop);
			Assert.assertEquals(Utility.isClicked(webElement, driver), true);
			Thread.sleep(5000);
		} else if (laptop.equals("Dell i7 8gb")) {

			WebElement webElement = driver.findElement(demoBlazeElements.dellI78GbLaptop);
			Assert.assertEquals(Utility.isClicked(webElement, driver), true);
			Thread.sleep(5000);
		} else {
			new AssertionError("Laptop does not exist! Try again.");
		}
	}

	@Then("^clicks on Add to cart$")
	public void clicks_on_add_to_cart() throws Throwable {

		driverWait.until(ExpectedConditions.visibilityOfElementLocated(demoBlazeElements.addToCart));
		WebElement webElement = driver.findElement(demoBlazeElements.addToCart);
		Assert.assertEquals(Utility.isClicked(webElement, driver), true);
		Thread.sleep(5000);

	}

	@Then("^accepts pop up confirmation$")
	public void accepts_pop_up_confirmation() throws Throwable {

		driverWait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(5000);

	}

	@Then("^customer clicks on Home$")
	public void customer_clicks_on_home() {

		driverWait.until(ExpectedConditions.elementToBeClickable(demoBlazeElements.homeLink));
		WebElement webElement = driver.findElement(demoBlazeElements.homeLink);
		Assert.assertEquals(Utility.isClicked(webElement, driver), true);

	}

	/*
	 * @Then("^clicks on (.*) laptop$") public void
	 * clicks_on_dell_i7_8gb_laptop(String laptop) {
	 * 
	 * }
	 */
	@Then("^customer clicks on Cart$")
	public void customer_clicks_on_cart() {

		driverWait.until(ExpectedConditions.visibilityOfElementLocated(demoBlazeElements.cartLink));
		WebElement webElement = driver.findElement(demoBlazeElements.cartLink);
		Assert.assertEquals(Utility.isClicked(webElement, driver), true);

	}

	@Then("^customer deletes (.*) laptop$")
	public void customer_deletes_dell_i7_8gb_laptop(String laptop) throws Throwable {

		driverWait.until(ExpectedConditions.visibilityOfElementLocated(demoBlazeElements.dellDelete));
		List<WebElement> noOfRows = driver.findElements(demoBlazeElements.listOfLaptops);
		int size = noOfRows.size();

		System.out.println("size is: " + size);
		for (int i = 1; i <= size; i++) {
			// String dellXpath = "//*[@id='tbodyid']/tr["+i+"]/td[2]";
			// String dellDeletexpath = "//*[@id='tbodyid']/tr["+i+"]/td[4]";
			demoBlazeElements.setDellXpath(i);
			String laptopName = driver.findElement(demoBlazeElements.getDellXpath()).getText();
			if (laptopName.equals("Dell i7 8gb")) {

				System.out.println("laptop found ! ");
				demoBlazeElements.setDellDeleteXpath(i);
				WebElement webElement = driver.findElement(demoBlazeElements.getDellDeletexpath());
				Assert.assertEquals(Utility.isClicked(webElement, driver), true);
				break;
			}

		}
		Thread.sleep(2000);

	}

	@Then("^customer clicks on Place order button$")
	public void customer_clicks_on_place_order_button() throws Throwable {

		driverWait.until(ExpectedConditions.elementToBeClickable(demoBlazeElements.placeOrderButton));
		expectedAmount = driver.findElement(demoBlazeElements.expectedAmount).getText();
		Assert.assertNotEquals(expectedAmount, null);
		System.out.println(expectedAmount);

		WebElement webElement = driver.findElement(demoBlazeElements.placeOrderButton);
		Assert.assertEquals(Utility.isClicked(webElement, driver), true);
		Thread.sleep(5000);

	}

	@Then("^customer fills the place order form with values (.*) (.*) (.*) (.*) (.*) (.*)$")
	public void customer_fills_the_place_order_form_with_values_apap_esp_bcn_jan(String name, String country,
			String city, String creditCard, String month, String year) throws Throwable {

		driverWait.until(ExpectedConditions.elementToBeClickable(demoBlazeElements.nameTxtbox));
		driver.findElement(demoBlazeElements.nameTxtbox).sendKeys(name);
		driver.findElement(demoBlazeElements.countryTxtbox).sendKeys(country);
		driver.findElement(demoBlazeElements.cityTxtbox).sendKeys(city);
		driver.findElement(demoBlazeElements.creditcardTxtbox).sendKeys(creditCard);
		driver.findElement(demoBlazeElements.monthTxtbox).sendKeys(month);
		driver.findElement(demoBlazeElements.yearTxtbox).sendKeys(year);
		Thread.sleep(3000);

	}

	@Then("^customer clicks on purchase button$")
	public void customer_clicks_on_purchase_button() {

		driverWait.until(ExpectedConditions.elementToBeClickable(demoBlazeElements.purchaseButton));
		WebElement webElement = driver.findElement(demoBlazeElements.purchaseButton);
		Assert.assertEquals(Utility.isClicked(webElement, driver), true);

	}

	@Then("^capture purchase id and purchase amount$")
	public void capture_purchase_id_and_purchase_amount() throws IOException {

		String filePath = Utility.captureScrrenShot(driver);

	}

	@Then("^log purchase id and purchase amount$")
	public void log_purchase_id_and_purchase_amount() {

		log.info("Purchase Id is : " + purchaseId + "\n Actual amount is : " + actualAmount);

	}

	String actualAmount;
	String purchaseId;

	@Then("^Verify the purchase amount with expected amount$")
	public void verify_the_purchase_amount_with_expected_amount() {

		driverWait.until(ExpectedConditions.visibilityOfElementLocated(demoBlazeElements.purchaseDetails));

		String purchaseDetails = driver.findElement(demoBlazeElements.purchaseDetails).getText();
		System.out.println("id is : " + purchaseDetails);

		String[] list;
		list = purchaseDetails.split(" ");
		purchaseId = list[1];
		actualAmount = list[2];
		System.out.println(
				"purchaseid is = " + purchaseId.substring(0, purchaseId.indexOf('A')) + " amount is = " + actualAmount);

		Assert.assertEquals(Integer.parseInt(expectedAmount), Integer.parseInt(actualAmount));

	}

	@Then("^customer clicks ok button$")
	public void customer_clicks_ok_button() {

		driverWait.until(ExpectedConditions.elementToBeClickable(demoBlazeElements.okButton));
		WebElement webElement = driver.findElement(demoBlazeElements.okButton);
		Assert.assertEquals(Utility.isClicked(webElement, driver), true);
	}

	@After
	public void cleanUp() {

		driver.quit();
	}
}
