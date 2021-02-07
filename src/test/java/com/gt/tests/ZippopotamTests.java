package com.gt.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.restassured.http.ContentType;

public class ZippopotamTests {

	ExtentReports extent;
	ExtentTest test;
	ExtentHtmlReporter htmlReporter;

	@BeforeClass(alwaysRun=true)
	public void setup() {
		System.out.println("Before Class");
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//reports//Extent_Report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@Test(groups = { "apiTest" })
	public void statusCodeTest() {

		try {

			test = extent.createTest("statusCodeTest");

			given().when().get("http://zippopotam.us/us/90210").then().assertThat().statusCode(200);

			test.log(Status.INFO, "statusCodeTest Passed");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(groups = { "apiTest" })
	public void contentTypeTest() {

		try {

			test = extent.createTest("contentTypeTest");

			// Enumeration
			given().when().get("http://zippopotam.us/us/{zip}", 90210).then().assertThat()
					.contentType(ContentType.JSON);

			// With value
			given().when().get("http://zippopotam.us/us/90210").then().assertThat().contentType("application/json");

			test.log(Status.INFO, "contentTypeTest Passed");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(groups = { "apiTest" })
	public void loggingTest() {

		try {
			test = extent.createTest("loggingTest");

			given().log().all().when().get("http://zippopotam.us/us/90210").then().log().body();

			test.log(Status.INFO, "loggingTest Passed");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(groups = { "apiTest" })
	public void validateBodyTest() {

		// Validate a value from an array - places[0]

		try {
			test = extent.createTest("validateBodyTest");

			given().when().get("http://zippopotam.us/us/90210").then().assertThat().body("places[0].'latitude'",
					equalTo("34.0901"));

			test.log(Status.INFO, "validateBodyTest Passed");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(groups = { "apiTest" })
	public void validateValueArrayTest() {

		// Validate a value from an array - places

		try {
			test = extent.createTest("validateValueArrayTest");

			given().when().get("http://zippopotam.us/us/90210").then().assertThat().body("places.'latitude'",
					hasItem("34.0901"));

			test.log(Status.INFO, "validateValueArrayTest Passed");
			
			System.out.println("Demo for #seleniumsummit2021");
			
			System.out.println("This is a demo");

		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	@AfterClass
	public void tearDown() {
		System.out.println("After tear Down");
		extent.flush();

	}

}