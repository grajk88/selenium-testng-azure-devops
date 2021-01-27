package com.gt.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;

public class ZippopotamTests {

	@Test(groups= {"apiTest"})
	public void statusCodeTest() {

		try {

			given().when().get("http://zippopotam.us/us/90210").then().assertThat().statusCode(200);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(groups= {"apiTest"})
	public void contentTypeTest() {

		try {

			// Enumeration
			given().when().get("http://zippopotam.us/us/{zip}", 90210).then().assertThat()
					.contentType(ContentType.JSON);

			// With value
			given().when().get("http://zippopotam.us/us/90210").then().assertThat().contentType("application/json");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(groups= {"apiTest"})
	public void loggingTest() {

		try {

			given().log().all().when().get("http://zippopotam.us/us/90210").then().log().body();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(groups= {"apiTest"})
	public void validateBodyTest() {

		// Validate a value from an array - places[0]

		try {

			given().when().get("http://zippopotam.us/us/90210").then().assertThat().body("places[0].'latitude'",
					equalTo("34.0901"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(groups= {"apiTest"})
	public void validateValueArrayTest() {

		// Validate a value from an array - places

		try {

			given().when().get("http://zippopotam.us/us/90210").then().assertThat().body("places.'latitude'",
					hasItem("34.0901"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void incognitoTest() {
		
		WebDriverManager.chromedriver().setup();

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(capabilities);
        driver.get("https://chercher.tech");
        System.out.println(driver.getTitle());
	}

}
