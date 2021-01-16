package com.gt.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

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

}
