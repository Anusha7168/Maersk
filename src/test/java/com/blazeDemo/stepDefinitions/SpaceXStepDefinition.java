package com.blazeDemo.stepDefinitions;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SpaceXStepDefinition {

	URL url = null;
	HttpURLConnection con = null;

	@Given("^I create GET URL request$")
	public void Initialize_the_browser_with_chrome() throws Throwable {
		url = new URL("https://api.spacexdata.com/v4/launches/latest");
	}

	@When("^Send a HTTP GET request$")
	public void Send_a_HTTP_GET_request() throws Throwable {
		con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
	}

	@Then("^I receive valid response$")
	public void I_receive_valid_response() throws Throwable {
		Assert.assertEquals(con.getResponseCode(), 200);
		InputStream is = con.getInputStream();
		String actualResponse = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8)).lines()
				.collect(Collectors.joining("\n"));
		System.out.println(actualResponse);
		// Assert.assertEquals(getExpectedResponse(), actualResponse);
	}

	public String getExpectedResponse() throws Exception {
		String file = "C:\\Maersk\\BlazeDemo\\response.json";
		String json = readFileAsString(file);
		return json;
	}

	public static String readFileAsString(String file) throws Exception {
		return new String(Files.readAllBytes(Paths.get(file)));
	}
}
