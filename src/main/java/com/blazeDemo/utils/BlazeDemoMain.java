package com.blazeDemo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BlazeDemoMain {

	public static WebDriver driver;
	public static Properties prop;
	public static String url;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Maersk\\BlazeDemo\\src\\main\\java\\com\\blazeDemo\\utils\\data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Maersk\\BlazeDemo\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			// execute in chrome driver

		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		return driver;

	}

	public String getUrl() {

		String url = prop.getProperty("url");
		return url;

	}

	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\screenshots\\" + result + "screenshot.png"));

	}

}
