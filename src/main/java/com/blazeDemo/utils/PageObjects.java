package com.blazeDemo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjects {

	public WebDriver driver;

	By departure = By.name("fromPort");
	By destination = By.name("toPort");
	By search = By.cssSelector("input[type='submit']");
	By chooseFlight = By.xpath("//body/table/tbody/tr[2]/td[1]/input");
	By name = By.id("inputName");
	By address = By.id("address");
	By city = By.id("city");
	By state = By.id("state");
	By zipCode = By.id("zipCode");
	By cardType = By.id("cardType");
	By creditCardNumber = By.id("creditCardNumber");
	By month = By.id("creditCardMonth");
	By year = By.id("creditCardYear");
	By NameOnCard = By.id("nameOnCard");
	By purchaseBtn = By.cssSelector("input[type='submit']");
	By flightNumber = By.xpath("//body/div[2]/p[2]");
	By message = By.xpath("//body/div[2]/div/h1");
	By idRow = By.xpath("//body/div[2]/div[1]/table/tbody/tr[1]/td[1]");

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getChooseFlight() {
		return (WebElement) driver.findElement(chooseFlight);
	}

	public WebElement getMessage() {
		return (WebElement) driver.findElement(message);
	}

	public WebElement getFlightNumber() {
		return (WebElement) driver.findElement(flightNumber);
	}

	public WebElement getName() {
		return (WebElement) driver.findElement(name);
	}

	public WebElement getAddress() {
		return (WebElement) driver.findElement(address);
	}

	public WebElement getCity() {
		return (WebElement) driver.findElement(city);
	}

	public WebElement getState() {
		return (WebElement) driver.findElement(state);
	}

	public WebElement getZipCode() {
		return (WebElement) driver.findElement(zipCode);
	}

	public WebElement getCardType() {
		return (WebElement) driver.findElement(cardType);
	}

	public WebElement getCreditCardNumber() {
		return (WebElement) driver.findElement(creditCardNumber);
	}

	public WebElement getMonth() {
		return (WebElement) driver.findElement(month);
	}

	public WebElement getYear() {
		return (WebElement) driver.findElement(year);
	}

	public WebElement getNameOnCard() {
		return (WebElement) driver.findElement(NameOnCard);
	}

	public WebElement getPurchaseBtn() {
		return (WebElement) driver.findElement(purchaseBtn);
	}

	public PageObjects(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement getSearchBtn() {
		return (WebElement) driver.findElement(search);
	}

	public WebElement getDeparture() {
		return driver.findElement(departure);
	}

	public WebElement getDstination() {
		return driver.findElement(destination);
	}

	public WebElement getIdHeader() {
		return driver.findElement(idRow);
	}

}
