package com.gt.tests;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZeroWebSecurityLoginTests {

	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser", "environment" })
	public void launchBrowser(String browser, String environment) {

		try {

			System.out.println("++++++++++++++++++++++++++++++++++++++++++");

			System.out.println("BROWSER: " + browser.toUpperCase().toString());

			System.out.println("ENVIRONMENT: " + environment.toUpperCase().toString());

			System.out.println("++++++++++++++++++++++++++++++++++++++++++");

			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("ignore-certificate-errors");

			driver = new ChromeDriver(options);

			driver.get("http://zero.webappsecurity.com/");

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(groups = { "smoke" })
	public void loginTestOne() {
		try {

			driver.findElement(By.id("signin_button")).click();
			driver.findElement(By.id("user_login")).sendKeys("username");
			driver.findElement(By.id("user_password")).sendKeys("password");
			driver.findElement(By.id("user_password")).submit();

			Thread.sleep(5000);

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/target/images/HomePage.jpg"));

			System.out
					.println("Added Screenshot to : " + System.getProperty("user.dir") + "/target/images/HomePage.jpg");

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(groups = { "regression" })
	public void loginTestTwo() {
		try {

			driver.findElement(By.id("signin_button")).click();
			driver.findElement(By.id("user_login")).sendKeys("username");
			driver.findElement(By.id("user_password")).sendKeys("password");
			driver.findElement(By.id("user_password")).submit();

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(groups = { "regression" })
	public void loginTestThree() {
		try {

			driver.findElement(By.id("signin_button")).click();
			driver.findElement(By.id("user_login")).sendKeys("username");
			driver.findElement(By.id("user_password")).sendKeys("password");
			driver.findElement(By.id("user_password")).submit();

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.assertTrue(false);
		}

	}

	@AfterTest()
	public void quitBrowser() {
		try {

			System.out.println("Called AfterMethod");
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.assertTrue(false);
		}
	}

}
