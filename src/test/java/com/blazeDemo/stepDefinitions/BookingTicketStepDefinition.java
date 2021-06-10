package com.blazeDemo.stepDefinitions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.blazeDemo.utils.BlazeDemoMain;
import com.blazeDemo.utils.PageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BookingTicketStepDefinition extends BlazeDemoMain {

	PageObjects objects;

	@Given("^Initialize the browser with chrome$")
	public void Initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeDriver();
		objects = new PageObjects(driver);
	}

	@And("^Navigate to url$")
	public void navigate_to_url() throws Throwable {
		driver.navigate().to("https://blazedemo.com");
	}

	@Given("^Choose Boston from the departure city dropdown list$")
	public void choose_Boston_from_the_departure_dropdown_list() throws Throwable {
		Select dptCity = new Select(objects.getDeparture());
		dptCity.selectByVisibleText("Boston");
	}

	@And("^Choose New York from the arrival city dropdown list$")
	public void choose_New_York_from_the_arrival_dropdown_list() throws Throwable {
		Select arvlCity = new Select(objects.getDstination());
		arvlCity.selectByVisibleText("New York");
	}

	@Given("^Click on Find Flights button$")
	public void click_on_search_button() throws Throwable {
		objects.getSearchBtn().click();
	}

	@Then("^Check if we land on the Search Flights page$")
	public void check_if_we_land_on_the_Search_Flights_page() throws Throwable {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("reserve.php"));
	}

	@Given("^search flights page is opened and flights are available$")
	public void search_flights_page_is_opened() throws Throwable {
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		Assert.assertTrue(rows.size() > 2);
	}

	@And("^choose united airlines flight$")
	public void choose_united_airlines_flight() throws Throwable {
		objects = new PageObjects(driver);
		List<WebElement> btn = driver.findElements(By.cssSelector("input[type='submit']"));
		btn.get(1).click();
	}

	@Then("Check if we land on the Purchase Flights page$")
	public void check_if_we_land_on_the_Purchase_Flights_page() throws Throwable {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("purchase.php"));
	}

	@Given("^Correct flight is selected$")
	public void purchase_flights_page_is_opened() throws Throwable {
		objects = new PageObjects(driver);
		Assert.assertEquals(objects.getFlightNumber().getText(), "Flight Number: UA954");
	}

	@And("^fill the form details$")
	public void fill_the_form_details() throws Throwable {
		objects.getName().sendKeys("John");
		objects.getAddress().sendKeys("HSR Layout");
		objects.getCity().sendKeys("Bangalore");
		objects.getState().sendKeys("Karnataka");
		objects.getZipCode().sendKeys("522007");
		Select cardType = new Select(objects.getCardType());
		cardType.selectByVisibleText("American Express");
		objects.getCreditCardNumber().sendKeys("123456");
		objects.getMonth().sendKeys("11");
		objects.getYear().sendKeys("2024");
		objects.getNameOnCard().sendKeys("John Smith");
		objects.getSearchBtn().click();
	}

	@Then("^Check if we land on the confirmation page$")
	public void check_if_we_land_on_the_confirmation_page() throws Throwable {
		Assert.assertTrue(driver.getCurrentUrl().contains("confirmation.php"));
		Assert.assertEquals(objects.getMessage().getText(), "Thank you for your purchase today!");
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		Assert.assertEquals(rows.size(), 8);
		Assert.assertEquals(objects.getIdHeader().getText(), "Id");
	}

	@Then("^close browser$")
	public void close_browser() throws Throwable {
		driver.close();
	}
}
